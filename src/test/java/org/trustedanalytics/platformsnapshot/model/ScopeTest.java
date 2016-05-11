/**
 * Copyright (c) 2015 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.trustedanalytics.platformsnapshot.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ScopeTest {

    @Test
    public void getCoreScope() {
        UUID coreGuid = UUID.randomUUID();
        assertEquals(Scope.CORE, Scope.resolve(coreGuid, coreGuid));
    }

    @Test
    public void getOtherScope() {
        UUID coreGuid = UUID.randomUUID();
        UUID testGuid = UUID.randomUUID();
        assertEquals(Scope.OTHER, Scope.resolve(coreGuid, testGuid));
    }

    @Test
    public void getOtherScopeForNullCoreGuid() {
        UUID coreGuid = null;
        UUID testGuid = UUID.randomUUID();
        assertEquals(Scope.OTHER, Scope.resolve(coreGuid, testGuid));
    }
}
