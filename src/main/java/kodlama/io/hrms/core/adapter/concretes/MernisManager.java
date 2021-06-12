package kodlama.io.hrms.core.adapter.concretes;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.adapter.abstracts.MernisService;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


@Service
public class MernisManager implements MernisService {

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		KPSPublicSoap client=new KPSPublicSoapProxy();
		boolean check=false;
		try {
			check = client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalityId()),
					jobSeeker.getFirstName().toUpperCase(), jobSeeker.getLastName().toUpperCase(),
					jobSeeker.getDateofBirth().getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return check;
		
	}

	
	

}
