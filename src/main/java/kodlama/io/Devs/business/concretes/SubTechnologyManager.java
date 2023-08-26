package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Devs.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllSubTechnologyResponse;
import kodlama.io.Devs.dataAccess.SubTechnologyRepository;
import kodlama.io.Devs.entities.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService {
	private SubTechnologyRepository subTechnologyRepository;

	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository) {
		this.subTechnologyRepository = subTechnologyRepository;
	}

	@Override
	public List<GetAllSubTechnologyResponse> getAll() {
		List<SubTechnology> technologies = subTechnologyRepository.findAll();
		List<GetAllSubTechnologyResponse> subTechnologyResponses = new ArrayList<GetAllSubTechnologyResponse>();

		for (SubTechnology technology : technologies) {
			GetAllSubTechnologyResponse responseItem = new GetAllSubTechnologyResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			subTechnologyResponses.add(responseItem);
		}
		return subTechnologyResponses;
	}

	@Override
	public boolean add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {

		SubTechnology subTechnology = new SubTechnology();
		subTechnology.setName(createSubTechnologyRequest.getName());
		
		SubTechnology st = subTechnologyRepository.findByName(createSubTechnologyRequest.getName());
		
		if (st != null) {
			throw new Exception("This name already exist. You can't add!!");
		}
		
		if(createSubTechnologyRequest.getName().isBlank()) {
			throw new Exception("Name can't be blank");
		}
		
		subTechnologyRepository.save(subTechnology);
		return true;
	}

	@Override
	public boolean delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {

		subTechnologyRepository.deleteById(deleteSubTechnologyRequest.getId());
		return true;
	}

	@Override
	public boolean update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {

		SubTechnology st = subTechnologyRepository.findByName(updateSubTechnologyRequest.getName());
		
		if (st != null) {
			throw new Exception("This name already exist. You can't update!!");
		}
		st.setName(updateSubTechnologyRequest.getName());
		subTechnologyRepository.save(st);
		return true;
	}

}
