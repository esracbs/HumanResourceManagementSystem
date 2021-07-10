package kodlamaio.HumanResourceManagementSystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.LinkTypeService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.LinkTypeDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LinkType;

import java.util.List;
@Service
public class LinkTypeManager implements LinkTypeService{

    private LinkTypeDao linkTypeDao;
    @Autowired
    public LinkTypeManager(LinkTypeDao linkTypeDao) {
        this.linkTypeDao = linkTypeDao;
    }

    @Override
    public DataResult<List<LinkType>> getAll() {
        return new SuccessDataResult<List<LinkType>>(linkTypeDao.findAll(),"listelendi");
    }

    @Override
    public Result add(LinkType linkType) {
        linkTypeDao.save(linkType);
        return new SuccessResult("Başarıyla eklendi");
    }
}
