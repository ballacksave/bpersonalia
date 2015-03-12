/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bareng.hr.back.entity;

/**
 * An Enumeration that represent gender type. Label can be used for resolving
 * label from message source (i18n related).
 *
 * @author Arief Prihasanto <ariefp5758 at gmail.com>
 */
public enum GenderType {
    MALE    ("label.entity.genderType.male"), 
    FEMALE  ("label.entity.genderType.female");
    
    private final String labelCode;
    private GenderType(String labelCode) {
        this.labelCode = labelCode;
    }
    public String getLabelCode() {
        return labelCode;
    }
}
