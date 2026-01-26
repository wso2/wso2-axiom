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

package org.apache.axiom.om.util;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMXMLBuilderFactory;

import javax.xml.stream.XMLStreamException;
import java.io.StringReader;

public class AXIOMUtil {
    /**
     * Create an OMElement from an XML fragment given as a string.
     *
     * @param xmlFragment the well-formed XML fragment
     * @return The OMElement created out of the string XML fragment.
     * @throws XMLStreamException
     */
    public static OMElement stringToOM(String xmlFragment) throws XMLStreamException {
        return stringToOM(OMAbstractFactory.getOMFactory(), xmlFragment);
    }

    /**
     * Create an OMElement from an XML fragment given as a string with secure processing option.
     *
     * @param xmlFragment the well-formed XML fragment
     * @param withSecRestrictions enable/disable security restrictions.
     * @return The OMElement created out of the string XML fragment.
     * @throws XMLStreamException Error while parsing the XML fragment.
     */
    public static OMElement stringToOM(String xmlFragment, boolean withSecRestrictions)
        throws XMLStreamException {
        return stringToOM(OMAbstractFactory.getOMFactory(), xmlFragment, withSecRestrictions);
    }
    
    /**
     * Create an OMElement from an XML fragment given as a string.
     *
     * @param omFactory the factory used to build the object model
     * @param xmlFragment the well-formed XML fragment
     * @return The OMElement created out of the string XML fragment.
     * @throws XMLStreamException
     */
    public static OMElement stringToOM(OMFactory omFactory, String xmlFragment)
            throws XMLStreamException {
        return stringToOM(omFactory, xmlFragment, false);
    }

    /**
     * Create an OMElement from an XML fragment given as a string.
     *
     * @param omFactory           the factory used to build the object model
     * @param xmlFragment         the well-formed XML fragment
     * @param withSecRestrictions enable secure processing by disabling DTD and external entity.
     * @return The OMElement created out of the string XML fragment.
     * @throws XMLStreamException Error while parsing the XML fragment.
     */
    public static OMElement stringToOM(OMFactory omFactory, String xmlFragment,
        boolean withSecRestrictions) throws XMLStreamException {

        if (xmlFragment != null) {
            if (withSecRestrictions) {
                return OMXMLBuilderFactory.createOMBuilderWithSec(omFactory,
                    new StringReader(xmlFragment)).getDocumentElement();
            } else {
                return OMXMLBuilderFactory.createOMBuilder(omFactory, new StringReader(xmlFragment))
                    .getDocumentElement();
            }
        }
        return null;
    }
}
