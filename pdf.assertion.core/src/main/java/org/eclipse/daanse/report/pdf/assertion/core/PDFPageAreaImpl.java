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

import org.apache.pdfbox.pdmodel.PDPage;
import org.eclipse.daanse.report.pdf.assertion.api.model.PDFPageArea;
import org.eclipse.daanse.report.pdf.assertion.api.model.PDFPoint;
import org.eclipse.daanse.report.pdf.assertion.api.model.PDFRectangle;

public class PDFPageAreaImpl implements PDFPageArea {

    private PDPage page;
    private PDFRectangle rectangle;

    private PDFPageAreaImpl() {
        // do not use
    }

    public PDFPageAreaImpl(PDPage page, PDFRectangle rectangle) {
        this();
        this.page = page;
        this.rectangle = rectangle;

    }

    public PDFPageAreaImpl(PDPage page, PDFPointImpl upperLeft, PDFPointImpl lowerRight) {
        this(page, new PDFRectangleImpl(upperLeft, lowerRight));

    }

    public PDFPageAreaImpl(PDPage page) {
        this(page, new PDFPointImpl(0, 0), new PDFPointImpl(page.getBBox().getWidth(), page.getBBox().getHeight()));
    }

    @Override
    public PDFPageArea getPageArea(PDFPoint upperLeft, PDFPoint lowerRight) {
        return new PDFPageAreaImpl(page, rectangle.subRectangle(upperLeft, lowerRight));
    }

}
