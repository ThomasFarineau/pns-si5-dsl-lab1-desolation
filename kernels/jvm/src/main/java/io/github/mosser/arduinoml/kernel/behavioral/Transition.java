package io.github.mosser.arduinoml.kernel.behavioral;

import io.github.mosser.arduinoml.kernel.generator.Visitable;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.*;

import java.util.ArrayList;
import java.util.List;

public class Transition implements Visitable {

	private State next;
	private List<Condition> condition = new ArrayList<>();
	private List<OPERATOR> opList = new ArrayList<>();


	public State getNext() {
		return next;
	}

	public void setNext(State next) {
		this.next = next;
	}

	public List<Condition> getCondition() {
		return condition;
	}

	public void setCondition(List<Condition> condition) {
		this.condition = condition;
	}

	public void addCondition(Condition condition) {
		this.condition.add(condition);
	}

	public List<OPERATOR> getOpList() {
		return opList;
	}

	public void setOpList(List<OPERATOR> opList) {
		this.opList = opList;
	}

	public void addOp(OPERATOR op) {
		this.opList.add(op);
	}
	

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
