/*
 * Copyright (c) 2017, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 * <p>
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.ballerina.core.interpreter;

import org.wso2.ballerina.core.model.Node;
import org.wso2.ballerina.core.model.NodeExecutor;
import org.wso2.ballerina.core.model.NodeVisitor;
import org.wso2.ballerina.core.model.values.BValue;

/**
 * {@code WorkerVarLocation} represents a location of a variable defined in a worker within the stack frame.
 *
 * @since 0.8.0
 */
public class WorkerVarLocation extends MemoryLocation implements Node {
    private int workerMemAddrOffset;

    public WorkerVarLocation(int workerMemAddrOffset) {
        this.workerMemAddrOffset = workerMemAddrOffset;
    }

    public int getworkerMemAddrOffset() {
        return workerMemAddrOffset;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public BValue execute(NodeExecutor executor) {
        return executor.visit(this);
    }
}