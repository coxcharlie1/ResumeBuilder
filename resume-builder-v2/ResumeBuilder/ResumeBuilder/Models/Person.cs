using System.ComponentModel.DataAnnotations;

namespace ResumeBuilder.Models
{
    public class Person
    {
        [Key]
        public int id { get; set; }

        public string firstName { get; set; }

        public string lastName { get; set; }

        public string emailAddress { get; set; }

        public string occupation { get; set; }

        public string education { get; set; }
        
    }
}
