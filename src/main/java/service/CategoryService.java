package service;
import model.Category;
import repository.CategoryRepository;
import java.sql.SQLException;
import java.util.Scanner;

public class CategoryService {

    private final Scanner scanner = new Scanner(System.in);
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void CreateCategory() throws SQLException {

        System.out.print("Please enter the name of the category you want: ");
        String name = scanner.next();

        System.out.println("Please enter a description of your Category: ");
        String description = scanner.next();

        Category category = new Category(name, description);

        int result = categoryRepository.CreateCategory(category);

        if (result == 1)
            System.out.println(name + "you successfully added :)");
        else
            System.out.println("something is wrong :/");

    }
    public void editeCategory() throws SQLException {

        System.out.println("please enter your Category Id: ");
        int id = scanner.nextInt();

        Category category = load(id);

        System.out.println("please enter your Category name: ");
        String CategoryName = scanner.next();

        category.setName(CategoryName);


        System.out.println("please enter your Category description: ");
        String CategoryDis = scanner.next();

        category.setDescription(CategoryDis);

        categoryRepository.editCategory(category);
        System.out.println(category);
    }

    private Category load(int id) throws SQLException {

        Category category = categoryRepository.load(id);
        return category;
    }

    public void deleteCategory() throws SQLException {

        System.out.println("enter brandId that you want delete :");
        int id = scanner.nextInt();

        Category category = load(id);
        categoryRepository.deleteCategory(category);
    }


}
