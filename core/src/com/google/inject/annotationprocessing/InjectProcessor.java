package com.google.inject.annotationprocessing;

import com.google.inject.Inject;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

import static javax.tools.Diagnostic.Kind.*;

@SupportedAnnotationTypes("com.google.inject.Inject")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class InjectProcessor extends AbstractProcessor {

    public InjectProcessor() {
        super();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element elem : roundEnv.getElementsAnnotatedWith(Inject.class)) {
            processingEnv.getMessager().printMessage(NOTE, elem.getAnnotation(Inject.class) + " annotation found in " + elem.getSimpleName());
        }
        return false;
    }
}
