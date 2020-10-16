package id.refactory.usecases.cases

import id.refactory.data.persistences.repositories.UserRepository
import id.refactory.domain.User
import id.refactory.usecases.infrastructures.UseCaseListener
import kotlinx.coroutines.*

class GetUsers(private var repository: UserRepository,) {
    private lateinit var job: Job

    fun getUsers(listener: UseCaseListener<List<User>>, params: Map<String, String>) {
        job = GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                listener.onComplete(repository.getUsers(params))
            }
        }
    }

    fun cancel() {
        if (::job.isInitialized) {
            job.cancel()
        }
    }
}