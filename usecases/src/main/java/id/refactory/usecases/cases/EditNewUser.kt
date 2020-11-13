package id.refactory.usecases.cases

import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.data.persistences.repositories.NewUserRepository
import id.refactory.domain.NewUser
import id.refactory.usecases.infrastructures.NewUseCaseListener
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class EditNewUser(
    private var repository: NewUserRepository,
    private var context: CoroutineContext
) {
    private lateinit var job: Job

    fun editUser(listener: NewUseCaseListener<NewUser>, path: Int, param: NewUserApiRequest) {
        job = GlobalScope.launch(context) {
            repository.editNewUsers(path, param)
                .flowOn(Dispatchers.IO)
//                .onStart { listener.onLoad(true) }
                .catch {
                    withContext(Dispatchers.Main) {
//                        listener.onLoad(false)
                        listener.onError(it)
                    }
                }
                .collect {
                    withContext(Dispatchers.Main) {
//                        listener.onLoad(false)
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