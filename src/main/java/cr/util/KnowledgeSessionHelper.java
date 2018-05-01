package cr.util;

import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

public class KnowledgeSessionHelper {
	public static KieContainer createRuleBase() {
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		return kieContainer;
	}
	
	public static StatelessKieSession getStatelessKnowledgeSession(KieContainer kieContainer, String sessionName) {
		StatelessKieSession kSession = kieContainer.newStatelessKieSession(sessionName);
		return kSession;
	}
	
	public static KieSession getStatefulKnowledgeSession(KieContainer kieContainer, String sessionName) {
		KieSession kSession = kieContainer.newKieSession(sessionName);
		
		return kSession;
	}
	
	public static KieSession getStatefulKnowledgeSessionWithCallBack (
			KieContainer kieContainer, String sessionName) {
		KieSession session = getStatefulKnowledgeSession(kieContainer, sessionName);
		session.addEventListener(new RuleRuntimeEventListener() {
			
			@Override
			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object inserted \n" + event.getObject().toString());
			}

			@Override
			public void objectDeleted(ObjectDeletedEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Object retracted \n" + event.getOldObject().toString());
			}

			@Override
			public void objectUpdated(ObjectUpdatedEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Object was updated \n" 
									+"new Content \n" +  event.getObject().toString());
			}
		});
		
		session.addEventListener(new AgendaEventListener() {
			public void matchCreated(MatchCreatedEvent event) {
				System.out.println("The rule "
						+ event.getMatch().getRule().getName()
						+ " can be fired in agenda");
			}
			
			public void matchCancelled(MatchCancelledEvent event) {
				System.out.println("The rule "
						+ event.getMatch().getRule().getName()
						+ " cannot be in agenda");
			}
			
			public void beforeMatchFired(BeforeMatchFiredEvent event) {
				System.out.println("The rule "
						+ event.getMatch().getRule().getName()
						+ " will be fired");
			}
			
			public void afterMatchFired(AfterMatchFiredEvent event) {
				System.out.println("The rule "
						+ event.getMatch().getRule().getName()
						+ " has be fired");
			}
			

			@Override
			public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void agendaGroupPopped(AgendaGroupPoppedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void agendaGroupPushed(AgendaGroupPushedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		
		return session;
	}

}
