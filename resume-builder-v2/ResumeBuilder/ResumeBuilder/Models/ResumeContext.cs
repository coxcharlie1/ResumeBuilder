using Microsoft.EntityFrameworkCore;

namespace ResumeBuilder.Models;

public class ResumeContext : DbContext
{
    //protected readonly IConfiguration configuration;
    public ResumeContext(DbContextOptions<ResumeContext> options) : base(options)
    {
        
    }
    /*
    protected override void OnConfiguring(DbContextOptionsBuilder options)
    {
        options.UseSqlServer(configuration.GetConnectionString("ResumeDatabase"));
    }*/

    public DbSet<Person> Person { get; set; }
    
}
