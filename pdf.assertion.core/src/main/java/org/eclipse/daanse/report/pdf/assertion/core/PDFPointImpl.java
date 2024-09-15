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
package org.eclipse.daanse.report.pdf.assertion.core;

import org.eclipse.daanse.report.pdf.assertion.api.model.PDFPoint;

public record PDFPointImpl(float x, float y) implements PDFPoint {

    public PDFPointImpl() {
        this(0, 0);
    }

    @Override
    public float getX() {
        return x();
    }

    @Override
    public float getY() {
        return y();
    }

}
