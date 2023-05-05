package org.example

@Grab('com.google.guava:guava:31.1-jre')
import com.google.common.base.*

def split = {input ->
    [on: {sep ->
        [trimming: { trimChar ->
            Splitter.on(sep).trimResults(CharMatcher.is(trimChar as char)).split(input).iterator().toList()
        }]
    }]
}


split "_a ,_b_ ,c__" on ',' trimming '_'

