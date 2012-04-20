/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

public class AspectbindReferenceResolverSwitch implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolverSwitch {
	
	protected org.emftext.language.aspectbind.resource.aspectbind.analysis.PerClausePointcutReferenceResolver perClausePointcutReferenceResolver = new org.emftext.language.aspectbind.resource.aspectbind.analysis.PerClausePointcutReferenceResolver();
	protected org.emftext.language.aspectbind.resource.aspectbind.analysis.IdPatternIdReferenceResolver idPatternIdReferenceResolver = new org.emftext.language.aspectbind.resource.aspectbind.analysis.IdPatternIdReferenceResolver();
	protected org.emftext.language.aspectbind.resource.aspectbind.analysis.AdapterDeclarationAdapteeReferenceResolver adapterDeclarationAdapteeReferenceResolver = new org.emftext.language.aspectbind.resource.aspectbind.analysis.AdapterDeclarationAdapteeReferenceResolver();
	protected org.emftext.language.aspectbind.resource.aspectbind.analysis.ClassifierImportClassifierReferenceResolver classifierImportClassifierReferenceResolver = new org.emftext.language.aspectbind.resource.aspectbind.analysis.ClassifierImportClassifierReferenceResolver();
	protected org.emftext.language.aspectbind.resource.aspectbind.analysis.StaticMemberImportStaticMembersReferenceResolver staticMemberImportStaticMembersReferenceResolver = new org.emftext.language.aspectbind.resource.aspectbind.analysis.StaticMemberImportStaticMembersReferenceResolver();
	protected org.emftext.language.aspectbind.resource.aspectbind.analysis.AnnotationInstanceAnnotationReferenceResolver annotationInstanceAnnotationReferenceResolver = new org.emftext.language.aspectbind.resource.aspectbind.analysis.AnnotationInstanceAnnotationReferenceResolver();
	protected org.emftext.language.aspectbind.resource.aspectbind.analysis.AnnotationAttributeSettingAttributeReferenceResolver annotationAttributeSettingAttributeReferenceResolver = new org.emftext.language.aspectbind.resource.aspectbind.analysis.AnnotationAttributeSettingAttributeReferenceResolver();
	protected org.emftext.language.aspectbind.resource.aspectbind.analysis.ClassifierReferenceTargetReferenceResolver classifierReferenceTargetReferenceResolver = new org.emftext.language.aspectbind.resource.aspectbind.analysis.ClassifierReferenceTargetReferenceResolver();
	protected org.emftext.language.aspectbind.resource.aspectbind.analysis.ElementReferenceTargetReferenceResolver elementReferenceTargetReferenceResolver = new org.emftext.language.aspectbind.resource.aspectbind.analysis.ElementReferenceTargetReferenceResolver();
	protected org.emftext.language.aspectbind.resource.aspectbind.analysis.JumpTargetReferenceResolver jumpTargetReferenceResolver = new org.emftext.language.aspectbind.resource.aspectbind.analysis.JumpTargetReferenceResolver();
	
	public org.emftext.language.aspectbind.resource.aspectbind.analysis.PerClausePointcutReferenceResolver getPerClausePointcutReferenceResolver() {
		return perClausePointcutReferenceResolver;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.analysis.IdPatternIdReferenceResolver getIdPatternIdReferenceResolver() {
		return idPatternIdReferenceResolver;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.analysis.AdapterDeclarationAdapteeReferenceResolver getAdapterDeclarationAdapteeReferenceResolver() {
		return adapterDeclarationAdapteeReferenceResolver;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.analysis.ClassifierImportClassifierReferenceResolver getClassifierImportClassifierReferenceResolver() {
		return classifierImportClassifierReferenceResolver;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.analysis.StaticMemberImportStaticMembersReferenceResolver getStaticMemberImportStaticMembersReferenceResolver() {
		return staticMemberImportStaticMembersReferenceResolver;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.analysis.AnnotationInstanceAnnotationReferenceResolver getAnnotationInstanceAnnotationReferenceResolver() {
		return annotationInstanceAnnotationReferenceResolver;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.analysis.AnnotationAttributeSettingAttributeReferenceResolver getAnnotationAttributeSettingAttributeReferenceResolver() {
		return annotationAttributeSettingAttributeReferenceResolver;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.analysis.ClassifierReferenceTargetReferenceResolver getClassifierReferenceTargetReferenceResolver() {
		return classifierReferenceTargetReferenceResolver;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.analysis.ElementReferenceTargetReferenceResolver getElementReferenceTargetReferenceResolver() {
		return elementReferenceTargetReferenceResolver;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.analysis.JumpTargetReferenceResolver getJumpTargetReferenceResolver() {
		return jumpTargetReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		perClausePointcutReferenceResolver.setOptions(options);
		idPatternIdReferenceResolver.setOptions(options);
		adapterDeclarationAdapteeReferenceResolver.setOptions(options);
		classifierImportClassifierReferenceResolver.setOptions(options);
		staticMemberImportStaticMembersReferenceResolver.setOptions(options);
		annotationInstanceAnnotationReferenceResolver.setOptions(options);
		annotationAttributeSettingAttributeReferenceResolver.setOptions(options);
		classifierReferenceTargetReferenceResolver.setOptions(options);
		elementReferenceTargetReferenceResolver.setOptions(options);
		jumpTargetReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.language.aspectbind.commons.CommonsPackage.eINSTANCE.getPerClause().isInstance(container)) {
			AspectbindFuzzyResolveResult<org.emftext.language.aspectbind.pointcuts.Pointcut> frr = new AspectbindFuzzyResolveResult<org.emftext.language.aspectbind.pointcuts.Pointcut>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("pointcut")) {
				perClausePointcutReferenceResolver.resolve(identifier, (org.emftext.language.aspectbind.commons.PerClause) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.aspectbind.patterns.PatternsPackage.eINSTANCE.getIdPattern().isInstance(container)) {
			AspectbindFuzzyResolveResult<org.emftext.language.java.references.Reference> frr = new AspectbindFuzzyResolveResult<org.emftext.language.java.references.Reference>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("id")) {
				idPatternIdReferenceResolver.resolve(identifier, (org.emftext.language.aspectbind.patterns.IdPattern) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.aspectbind.declaration.DeclarationPackage.eINSTANCE.getAdapterDeclaration().isInstance(container)) {
			AspectbindFuzzyResolveResult<org.emftext.language.aspectbind.binding.InstancePointcut> frr = new AspectbindFuzzyResolveResult<org.emftext.language.aspectbind.binding.InstancePointcut>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("adaptee")) {
				adapterDeclarationAdapteeReferenceResolver.resolve(identifier, (org.emftext.language.aspectbind.declaration.AdapterDeclaration) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.imports.ImportsPackage.eINSTANCE.getClassifierImport().isInstance(container)) {
			AspectbindFuzzyResolveResult<org.emftext.language.java.classifiers.ConcreteClassifier> frr = new AspectbindFuzzyResolveResult<org.emftext.language.java.classifiers.ConcreteClassifier>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("classifier")) {
				classifierImportClassifierReferenceResolver.resolve(identifier, (org.emftext.language.java.imports.ClassifierImport) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.imports.ImportsPackage.eINSTANCE.getStaticMemberImport().isInstance(container)) {
			AspectbindFuzzyResolveResult<org.emftext.language.java.references.ReferenceableElement> frr = new AspectbindFuzzyResolveResult<org.emftext.language.java.references.ReferenceableElement>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("staticMembers")) {
				staticMemberImportStaticMembersReferenceResolver.resolve(identifier, (org.emftext.language.java.imports.StaticMemberImport) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.annotations.AnnotationsPackage.eINSTANCE.getAnnotationInstance().isInstance(container)) {
			AspectbindFuzzyResolveResult<org.emftext.language.java.classifiers.Classifier> frr = new AspectbindFuzzyResolveResult<org.emftext.language.java.classifiers.Classifier>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("annotation")) {
				annotationInstanceAnnotationReferenceResolver.resolve(identifier, (org.emftext.language.java.annotations.AnnotationInstance) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.annotations.AnnotationsPackage.eINSTANCE.getAnnotationAttributeSetting().isInstance(container)) {
			AspectbindFuzzyResolveResult<org.emftext.language.java.members.InterfaceMethod> frr = new AspectbindFuzzyResolveResult<org.emftext.language.java.members.InterfaceMethod>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("attribute")) {
				annotationAttributeSettingAttributeReferenceResolver.resolve(identifier, (org.emftext.language.java.annotations.AnnotationAttributeSetting) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.types.TypesPackage.eINSTANCE.getClassifierReference().isInstance(container)) {
			AspectbindFuzzyResolveResult<org.emftext.language.java.classifiers.Classifier> frr = new AspectbindFuzzyResolveResult<org.emftext.language.java.classifiers.Classifier>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				classifierReferenceTargetReferenceResolver.resolve(identifier, (org.emftext.language.java.types.ClassifierReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.references.ReferencesPackage.eINSTANCE.getElementReference().isInstance(container)) {
			AspectbindFuzzyResolveResult<org.emftext.language.java.references.ReferenceableElement> frr = new AspectbindFuzzyResolveResult<org.emftext.language.java.references.ReferenceableElement>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				elementReferenceTargetReferenceResolver.resolve(identifier, (org.emftext.language.java.references.ElementReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.statements.StatementsPackage.eINSTANCE.getJump().isInstance(container)) {
			AspectbindFuzzyResolveResult<org.emftext.language.java.statements.JumpLabel> frr = new AspectbindFuzzyResolveResult<org.emftext.language.java.statements.JumpLabel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				jumpTargetReferenceResolver.resolve(identifier, (org.emftext.language.java.statements.Jump) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.emftext.language.aspectbind.commons.CommonsPackage.eINSTANCE.getPerClause_Pointcut()) {
			return perClausePointcutReferenceResolver;
		}
		if (reference == org.emftext.language.aspectbind.patterns.PatternsPackage.eINSTANCE.getIdPattern_Id()) {
			return idPatternIdReferenceResolver;
		}
		if (reference == org.emftext.language.aspectbind.declaration.DeclarationPackage.eINSTANCE.getAdapterDeclaration_Adaptee()) {
			return adapterDeclarationAdapteeReferenceResolver;
		}
		if (reference == org.emftext.language.java.imports.ImportsPackage.eINSTANCE.getClassifierImport_Classifier()) {
			return classifierImportClassifierReferenceResolver;
		}
		if (reference == org.emftext.language.java.imports.ImportsPackage.eINSTANCE.getStaticMemberImport_StaticMembers()) {
			return staticMemberImportStaticMembersReferenceResolver;
		}
		if (reference == org.emftext.language.java.annotations.AnnotationsPackage.eINSTANCE.getAnnotationInstance_Annotation()) {
			return annotationInstanceAnnotationReferenceResolver;
		}
		if (reference == org.emftext.language.java.annotations.AnnotationsPackage.eINSTANCE.getAnnotationAttributeSetting_Attribute()) {
			return annotationAttributeSettingAttributeReferenceResolver;
		}
		if (reference == org.emftext.language.java.types.TypesPackage.eINSTANCE.getClassifierReference_Target()) {
			return classifierReferenceTargetReferenceResolver;
		}
		if (reference == org.emftext.language.java.references.ReferencesPackage.eINSTANCE.getElementReference_Target()) {
			return elementReferenceTargetReferenceResolver;
		}
		if (reference == org.emftext.language.java.statements.StatementsPackage.eINSTANCE.getJump_Target()) {
			return jumpTargetReferenceResolver;
		}
		return null;
	}
	
}
