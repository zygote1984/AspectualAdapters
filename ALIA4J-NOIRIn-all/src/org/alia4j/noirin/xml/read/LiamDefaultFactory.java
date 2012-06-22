package org.alia4j.noirin.xml.read;

import org.alia4j.fial.predicate.AtomicPredicateFactoryImpl;
import org.alia4j.noirin.action.ActionFactoryImpl;
import org.alia4j.noirin.context.ContextFactoryImpl;
import org.alia4j.noirin.typehierarchy.TypeHierarchyProviderImpl;
import org.dom4j.Element;

public class LiamDefaultFactory extends LiamFactory {
	
	public static void initialize() {
		new LiamDefaultFactory();
	}
	
	@Override
	protected ExtendedProductionResult extendedElementProducer(String type, Element elm) {
		return new ExtendedProductionResult(false);
	}

	@Override
	protected void factoriesInitialization() {
		if(LiamFactory.needInitialized) {
			TypeHierarchyProviderImpl.initialize();
			ContextFactoryImpl.initialize();
			AtomicPredicateFactoryImpl.initialize();
			ActionFactoryImpl.initialize();
		}
	}
}
