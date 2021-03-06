package org.amshove.kluent.tests.assertions.time.localdatetime

import org.amshove.kluent.before
import org.amshove.kluent.days
import org.amshove.kluent.shouldBeAtLeast
import java.time.LocalDateTime
import kotlin.test.Test
import kotlin.test.assertFails

class ShouldBeAtLeastXDaysBeforeShould {
    val orderDate = LocalDateTime.of(2017, 6, 15, 10, 0)

    @Test
    fun passWhenPassingADateWhichIsExactlyXDaysBefore() {
        val shippingDate = LocalDateTime.of(2017, 6, 10, 10, 0)
        shippingDate shouldBeAtLeast 5.days() before orderDate
    }

    @Test
    fun passWhenPassingADateWhichIsMoreThanXDaysBefore() {
        val shippingDate = LocalDateTime.of(2017, 6, 9, 10, 0)
        shippingDate shouldBeAtLeast 5.days() before orderDate
    }

    @Test
    fun failWhenPassingADateWhichIsLessThanXDaysBefore() {
        val shippingDate = LocalDateTime.of(2017, 6, 12, 10, 0)
        assertFails { shippingDate shouldBeAtLeast 5.days() before orderDate }
    }
}