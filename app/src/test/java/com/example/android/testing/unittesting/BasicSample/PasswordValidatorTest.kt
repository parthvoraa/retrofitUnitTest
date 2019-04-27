package com.example.android.testing.unittesting.BasicSample

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by lenovo on 3/29/2019.
 */
class PasswordValidatorTest {

    @Test
    fun PasswordValidator_CorrectPassword_ReturnsTrue() {
        assertTrue(PasswordValidator.isPasswordValid("Test@123"))
    }

    @Test
    fun PasswordValidator_PasswordWithSpace_ReturnsFalse() {
        assertFalse(PasswordValidator.isPasswordValid("Test @123"))
    }

    @Test
    fun PasswordValidator_PasswordWithoutUpperChar_ReturnsFalse() {
        assertFalse(PasswordValidator.isPasswordValid("test@123"))
    }

    @Test
    fun PasswordValidator_PasswordWithoutSpecialChar_ReturnFalse() {
        assertFalse(PasswordValidator.isPasswordValid("test123"))
    }

    @Test
    fun PasswordValidator_PasswordWithoutNumber_ReturnFalse() {
        assertFalse(PasswordValidator.isPasswordValid("test@A"))
    }

    @Test
    fun PasswordValidator_PasswordWithoutLowerChar_ReturnFalse() {
        assertFalse(PasswordValidator.isPasswordValid("TEST123"))
    }

    @Test
    fun PasswordValidator_EmptyString_RetunsFalse() {
        assertFalse(PasswordValidator.isPasswordValid(""))
    }

    @Test
    fun PasswordValidator_Null_RetunsFalse() {
        assertFalse(PasswordValidator.isPasswordValid(null))
    }

}