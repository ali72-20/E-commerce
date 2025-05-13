package com.example.domain.use_cases.auth_use_cases

import UserEntity
import app.cash.turbine.test
import com.example.domain.core.ApiResult
import com.example.domain.entities.request_entities.LoginRequestEntity
import com.example.domain.repository.AuthRepository
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class LoginUseCaseTest {
    lateinit var loginUseCase: LoginUseCase
    lateinit var authRepository: AuthRepository
    @Before
    fun init(){
        authRepository = mock()
        loginUseCase = LoginUseCase(authRepository)
    }
    @Test
    fun `loin user test return success`() = runTest{
        val emil = "test@example.com"
        val password = "passwordtest"
        val loginRequestEntity = LoginRequestEntity(emil,password)
        val user = UserEntity("test","test@example.com","test")
        val expectedFlow = flowOf(ApiResult.Success(user))
        `when` (authRepository.login(loginRequestEntity)).thenReturn(expectedFlow)


        val result = loginUseCase.invoke(loginRequestEntity)

        result.test{
            val emission = awaitItem()
            assertTrue(emission is ApiResult.Success)
            assertEquals(user, (emission as ApiResult.Success).data)
            awaitComplete()
        }
    }

}