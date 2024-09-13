/*
* Copyright (c) 2024 Contributors to the Eclipse Foundation.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*   Stefan Bischof (bipolis.org) - initial
*/
package org.eclipse.daanse.report.pdf.assertion.assertj;

import org.assertj.core.api.AbstractObjectAssert;
import org.eclipse.daanse.report.pdf.assertion.api.model.PDFDocument;

public abstract class AbstractPDFocumentAssert<S extends AbstractPDFocumentAssert<S, A>, A extends PDFDocument>
        extends AbstractObjectAssert<S, A> {

    protected AbstractPDFocumentAssert(A actual, Class<S> selfType) {
        super(actual, selfType);
    }

    public S hasNoPages() {
        // check that actual PDDocument we want to make assertions on is not null.
        isNotNull();

        // we override the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have pages but had :\n  <%s>";

        // check
        if (actual.getPDFPages().isEmpty()) {
            failWithMessage(assertjErrorMessage, actual, actual.getPDFPages());
        }

        // return the current assertion for method chaining
        return myself;
    }

}
