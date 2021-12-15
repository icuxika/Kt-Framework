package com.icuxika.kt.framework

import com.icuxika.kt.framework.Library
import kotlin.test.Test
import kotlin.test.assertTrue

class LibraryTest {
    @Test fun someLibraryMethodReturnsTrue() {
        val classUnderTest = Library()
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'")
    }
}
