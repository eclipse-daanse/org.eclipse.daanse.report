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

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.eclipse.daanse.report.pdf.assertion.api.PDFAssertionService;
import org.eclipse.daanse.report.pdf.assertion.api.model.PDFDocument;

public class PDFAssertionServiceImpl implements PDFAssertionService {

    @Override
    public PDFDocument read(File pdfFile) throws IOException {

        try (PDDocument document = Loader.loadPDF(pdfFile)) {
            return new PdfDocumentImpl(document);
        }

    }

    @Override
    public PDFDocument read(byte[] pdfBytes) throws IOException {
        try (PDDocument document = Loader.loadPDF(pdfBytes)) {
            return new PdfDocumentImpl(document);
        }
    }

}
