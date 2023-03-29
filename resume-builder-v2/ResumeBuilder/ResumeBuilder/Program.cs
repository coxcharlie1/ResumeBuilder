using Microsoft.EntityFrameworkCore;
using ResumeBuilder.Models;
using ResumeBuilder.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
var origins = "AllowSpecificOrigins";
builder.Services.AddCors(options => 
    options.AddPolicy(name: origins,
        policy =>
        {
            policy.WithOrigins("http://localhost:3000")
                                .AllowAnyHeader()
                                .AllowAnyMethod();
        }
        )
    );


builder.Services.AddDbContext<ResumeContext>(
    options => options.UseSqlServer(
        builder.Configuration.GetConnectionString("ResumeDatabase")));

builder.Services.AddScoped<PersonService>();

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseCors(origins);
app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
