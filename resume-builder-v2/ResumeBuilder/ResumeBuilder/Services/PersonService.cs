//using Person.Models;
using Microsoft.EntityFrameworkCore;
using ResumeBuilder.Models;
//using ResumeBuilder.Repository;


namespace ResumeBuilder.Services
{
    public class PersonService
    {
        private ResumeContext context;

        public PersonService(ResumeContext resumeContext)
        {
            this.context = resumeContext;
        }

        public IEnumerable<Person> GetAll()
        {
            return context.Person;
        }
    }
}
