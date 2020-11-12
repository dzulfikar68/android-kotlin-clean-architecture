package id.refactory.usecases.cases

import id.refactory.data.persistences.repositories.NewUserRepository
import id.refactory.domain.NewUser
import id.refactory.usecases.infrastructures.NewUseCaseListener
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlin.coroutines.CoroutineContext

class ShowNewUser(
    private var repository: NewUserRepository,
    private var context: CoroutineContext
) {
    private lateinit var job: Job

    fun showUser(listener: NewUseCaseListener<NewUser>, path: Int) {
        job = GlobalScope.launch(context) {
            repository.showNewUsers(path)
                .flowOn(Dispatchers.IO)
                .onStart { listener.onLoad(true) }
                .catch {
                    withContext(Dispatchers.Main) {
                        listener.onLoad(false)
                        listener.onError(it)
                    }
                }
                .collect {
                    withContext(Dispatchers.Main) {
                        listener.onLoad(false)
                        listener.onComplete(it ?: NewUser())
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