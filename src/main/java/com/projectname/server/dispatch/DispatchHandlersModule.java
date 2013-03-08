/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.projectname.server.dispatch;

import com.projectname.server.dispatch.validators.AdminActionValidator;
import com.projectname.shared.dispatch.FetchAdminTaskCountAction;
import com.projectname.shared.dispatch.FetchCurrentUserAction;
import com.projectname.shared.dispatch.FetchTaskAction;
import com.gwtplatform.dispatch.server.guice.HandlerModule;

public class DispatchHandlersModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(FetchTaskAction.class, FetchTaskHandler.class);
        bindHandler(FetchCurrentUserAction.class, FetchCurrentUserHandler.class);
        
        // This fetch has a Validator which only lets App Admins fetch it.
        bindHandler(FetchAdminTaskCountAction.class, FetchAdminTaskCountHandler.class, AdminActionValidator.class);
    }
}
