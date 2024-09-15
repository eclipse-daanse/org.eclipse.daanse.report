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
import org.eclipse.daanse.report.pdf.assertion.api.model.PDFRectangle;

public record PDFRectangleImpl(PDFPoint upperLeft, PDFPoint lowerRight) implements PDFRectangle {

    @Override
    public PDFPoint getUpperLeft() {
        return upperLeft();
    }

    @Override
    public PDFPoint getLowerRight() {
        return lowerRight();
    }

    @Override
    public float getWidth() {
        return lowerRight().getX() - upperLeft().getX();
    }

    @Override
    public float getHeight() {
        return lowerRight().getY() - upperLeft().getY();
    }

    @Override
    public PDFRectangle subRectangle(PDFPoint innerUpperLeft, PDFPoint innerLowerRight) {


        assert  innerUpperLeft.getX()>= upperLeft().getX();
        assert  innerUpperLeft.getY()>= upperLeft().getY();
        assert  innerLowerRight.getX()<= lowerRight().getX();
        assert  innerLowerRight.getY()<= lowerRight().getY();

        PDFPoint newUpperLeft = new PDFPointImpl(upperLeft().getX() + innerUpperLeft.getX(),
                upperLeft().getY() + innerUpperLeft.getY());

        PDFPoint newLowerLeft = new PDFPointImpl(upperLeft().getX() + innerLowerRight.getX(),
                upperLeft().getY() + innerLowerRight.getY());

        return new PDFRectangleImpl(newUpperLeft, newLowerLeft);
    }

    @Override
    public PDFRectangle subRectangle(PDFPoint innerUpperLeft, float width, float hight) {
        return subRectangle(innerUpperLeft, new PDFPointImpl(upperLeft().getX() + width, upperLeft().getY() + hight));
    }
}
