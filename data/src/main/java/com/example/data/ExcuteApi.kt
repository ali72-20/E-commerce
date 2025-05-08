import com.example.domain.core.ApiResult

suspend fun<T> safeApiCall(apiCall:suspend ()-> T): ApiResult<T> {
     try {
        val response = apiCall()
      return  ApiResult.Success(response)
    }catch (e: Exception){
       return ApiResult.Failure(exception = e)
    }
}