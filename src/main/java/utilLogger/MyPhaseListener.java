package utilLogger;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.deltaspike.jsf.api.listener.phase.AfterPhase;
import org.apache.deltaspike.jsf.api.listener.phase.BeforePhase;
import org.apache.deltaspike.jsf.api.listener.phase.JsfPhaseId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MyPhaseListener.class);

	public void beforePhase(@Observes @BeforePhase(JsfPhaseId.ANY_PHASE) PhaseEvent e) {
		log.info("=========== begin :" + e.getPhaseId().toString());
	}

	public void afterPhase(@Observes @AfterPhase(JsfPhaseId.ANY_PHASE) PhaseEvent e) {
		log.info("===========  end   :" + e.getPhaseId().toString());
	}


	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
}
