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

import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.eclipse.daanse.report.pdf.assertion.api.model.PDFDocument;
import org.eclipse.daanse.report.pdf.assertion.api.model.PDFPage;

public class PdfDocumentImpl implements PDFDocument {

    private PDDocument document;
    private List<PDFPage> pages;

    private PdfDocumentImpl() {
        // do not use
    }

    public PdfDocumentImpl(PDDocument pdDocument) {
        this();
        this.document = pdDocument;

    }

    @Override
    public List<PDFPage> getPDFPages() {

        if (pages == null) {
            synchronized (pages) {
                List<PDFPage> list = new ArrayList<>();
                for (PDPage page : document.getPages()) {
                    list.add(new PDFPageImpl(page));
                }
                pages = List.copyOf(list);
            }
        }

        return pages;

    }

}
