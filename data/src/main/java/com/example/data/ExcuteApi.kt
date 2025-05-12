import com.example.domain.core.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

suspend fun <T> safeApiCall(apiCall: suspend () -> T): Flow<ApiResult<T>> = flow {
    emit(ApiResult.Loading())
    try {
        val response = apiCall()
        emit(ApiResult.Success(response))
    } catch (e: Exception) {
        emit(ApiResult.Failure(e))
    }
}