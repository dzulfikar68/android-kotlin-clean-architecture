package id.refactory.usecases.infrastructures

interface NewUseCaseListener<T> {
    fun onError(e: Throwable)
    fun onLoad(load: Boolean)
    fun onComplete(data: T)
}