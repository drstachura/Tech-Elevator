using ProjectOrganizer.Models;
using System.Collections.Generic;

namespace ProjectOrganizer.DAL
{
    public interface IEmployeeDAO
    {
        /// <summary>
        /// Returns a list of all of the employees.
        /// </summary>
        /// <returns>A list of all employees.</returns>
        IList<Employee> GetAllEmployees();

        /// <summary>
        /// Searches the system for an employee by first name or last name.
        /// </summary>
        /// <remarks>The search performed is a wildcard search.</remarks>
        /// <param name="firstname"></param>
        /// <param name="lastname"></param>
        /// <returns>A list of employees that match the search.</returns>
        IList<Employee> Search(string firstname, string lastname);

        /// <summary>
        /// Gets a list of employees who are not assigned to any active projects.
        /// </summary>
        /// <returns></returns>
        IList<Employee> GetEmployeesWithoutProjects();
    }
}
