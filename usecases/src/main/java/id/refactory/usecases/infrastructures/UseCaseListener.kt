package id.refactory.usecases.infrastructures

interface UseCaseListener<T>  {
    fun onError(e: Throwable)
    fun onComplete(data: T)
}