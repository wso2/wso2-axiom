/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.axiom.util.base64;

import java.io.CharArrayWriter;

/**
 * Modified {@link CharArrayWriter} that returns the internal buffer (instead of a copy) if the
 * buffer has just the right size, i.e. if the size of the buffer is equal to the number of
 * characters that have been written.
 */
class NoCopyCharArrayWriter extends CharArrayWriter {
    NoCopyCharArrayWriter(int expectedSize) {
        super(expectedSize);
    }

    public char[] toCharArray() {
        return count == buf.length ? buf : super.toCharArray();
    }
}

