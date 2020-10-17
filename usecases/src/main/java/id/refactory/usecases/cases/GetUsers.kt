package id.refactory.usecases.cases

import id.refactory.data.persistences.repositories.UserRepository
import id.refactory.domain.User
import id.refactory.usecases.infrastructures.UseCaseListener
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class GetUsers(private var repository: UserRepository, private var context: CoroutineContext) {
    private lateinit var job: Job

    fun getUsers(listener: UseCaseListener<List<User>>, params: Map<String, String>) {
        job = GlobalScope.launch(context) {
            repository.getUsers(params)
                .flowOn(Dispatchers.IO)
                .catch { listener.onError(it) }
                .collect {
                    withContext(Dispatchers.Main) {
                        listener.onComplete(it)
                    }
                }
        }
    }

    fun cancel() {
        if (::job.isInitialized) {
            job.cancel()
        }
    }
}