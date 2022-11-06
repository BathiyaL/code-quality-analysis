package com.moduleB.basicRules;

import java.io.File;

public class RulesRelatesToMethods {
	protected boolean createEmptyZip(File zipFile, String emptyBehavior, boolean createEmpty, boolean skipWriting) {
		if (!createEmpty) {
			return true;
		}
		if ("skip".equals(emptyBehavior)) {
			if (!skipWriting) {
				System.out.println("Warning: skipping ");
			}
			return true;
		}
		if ("fail".equals(emptyBehavior)) {
			System.out.println("Cannot create ");
		}
		return true;
	}

}
