package model;

public class OpenQuestion extends A_Question {

	private static final long serialVersionUID = 7079014217442283143L; // auto-generated by serializable
	private Answer answer = new Answer();

	public OpenQuestion() {
		this.type = E_QuestionType.eOPEN_QUESTION;
	}
	
	
	public OpenQuestion(String quest, String answer) {
		super(quest);
		this.answer = new Answer(answer, true);
		this.type = E_QuestionType.eOPEN_QUESTION;
	}

	public OpenQuestion(OpenQuestion question) {
		super(question.quest);
		this.answer = new Answer(question.getAnswer());
		this.type = E_QuestionType.eOPEN_QUESTION;
	}

	public Answer getAnswer() {
		return this.answer;
	}

	public boolean setAnswer(String answer) {
		this.answer.setIsTrue(true);
		return this.answer.setAnswer(answer);
	}

	@Override
	public boolean addAnswer(String answer, boolean isTrue) {
		if (this.answer == null && isTrue) {
			this.answer = new Answer(answer, isTrue);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAnswer(int answerIndex) {
		this.answer = null;
		return true;
	}

	@Override
	public boolean isValid() {
		return (answer != null);
	}

	@Override
	public boolean setAnswerLength() {
		answerLength = answer.getLength();
		return true;
	}

	@Override
	public String toStringForTest() {
		return "Question: " + quest;
	}

	@Override
	public boolean equals(Object obj) { // if the string quests are the same and the question type is the same the
										// questions are equal
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) // defines Open or multi choice question
			return false;
		OpenQuestion other = (OpenQuestion) obj;
		return (quest.compareToIgnoreCase(other.quest) == 0);
	}

	@Override
	public String toString() {
		return "Question: " + quest + " | " + ((answer != null) ? answer.toString() : "No answer");
	}

}