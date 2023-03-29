using ResumeBuilder.Models;

namespace ResumeBuilder.Repository
{
    public interface IPersonRepository
    {

        IEnumerable<Person> GetAll();
    }
}
