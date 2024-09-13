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

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ServiceLoader;

import org.eclipse.daanse.report.pdf.assertion.api.PDFAssertionService;
import org.eclipse.daanse.report.pdf.assertion.api.model.PDFDocument;

public class Assertions {

    private static final RuntimeException RUNTIME_EXCEPTION = new RuntimeException(
            "no PDFService found using ServiceLoader");
    private static final ServiceLoader<PDFAssertionService> SERVICELOADER = ServiceLoader
            .load(PDFAssertionService.class);

    static PDFAssertionService pdfService() {
        return SERVICELOADER.findFirst().orElseThrow(() -> RUNTIME_EXCEPTION);
    }

    @org.assertj.core.util.CheckReturnValue
    public static PDFDocumentAssert assertThat(PDFDocument actual) {
        return new PDFDocumentAssert(actual);
    }

    @org.assertj.core.util.CheckReturnValue
    public static PDFDocumentAssert assertThat(Path pdfFilePath) throws IOException {
        return assertThat(pdfFilePath.toFile());
    }

    @org.assertj.core.util.CheckReturnValue
    public static PDFDocumentAssert assertThat(File pdfBytes) throws IOException {

        PDFDocument pdfDocument = pdfService().read(pdfBytes);
        return assertThat(pdfDocument);
    }

    @org.assertj.core.util.CheckReturnValue
    public static PDFDocumentAssert assertThat(byte[] pdfBytes) throws IOException {

        PDFDocument pdfDocument = pdfService().read(pdfBytes);
        return assertThat(pdfDocument);
    }

    protected Assertions() {
        // empty
    }
}
