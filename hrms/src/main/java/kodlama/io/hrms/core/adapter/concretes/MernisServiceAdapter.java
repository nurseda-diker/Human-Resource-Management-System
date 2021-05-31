package kodlama.io.hrms.core.adapter.concretes;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import kodlama.io.hrms.core.adapter.abstracts.UserCheckService;
import kodlama.io.hrms.entities.concretes.JobSeekers;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


@Component
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(JobSeekers jobSeeker) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean check=false;
		try {
			check=client.TCKimlikNoDogrula(
						Long.valueOf(jobSeeker.getNationalityId()), 
						jobSeeker.getFirstName(), 
						jobSeeker.getLastName(), 
						jobSeeker.getDateofBirth());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return check;
		
	}

	
	

}
