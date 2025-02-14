/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.apache.dubbo.samples.callback;

import org.apache.dubbo.samples.callback.api.CallbackService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CallbackConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/callback-consumer.xml");
        context.start();

        CallbackService callbackService = context.getBean("callbackService", CallbackService.class);
        // 用普通服务提供者，同时指定回调实现，同时指 定key和对应的回调方法
        callbackService.addListener("foo.bar", msg -> System.out.println("callback:" + msg));
        System.in.read();
    }

}
