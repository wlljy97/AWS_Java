package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> subjects = Arrays.asList(new String[] {"c", "Java", "Ptyhon"});
		SubjectService subjectService = new SubjectService(subjects);
		subjectService.showSubjects();
	}
}
