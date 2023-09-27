Business Need: example 1

  #@UI
#  Scenario: links test 1
#    Given users goes to homepage
#    When user clicks on home button
#    Then verify url is "https://test.kesifplus.com/"
#
#    When user clicks on about us button
#    Then verify url is "https://test.kesifplus.com/about-us"
#
#  #@UI
#  Scenario: link test 2
#    Given users goes to homepage
#    Then assert with enum


    # Scenario Outline ve Scenario Template ayni görevi görürler.
    # Scenario Outline yazacaksak EN SONA Examples kismi eklememiz gerekir. Examples'dan sonra baska adim eklenemez!
    # Eger bir testi yaparken belirli degerlerle islem yapilacak, browser kapatilip baska degerlerle ayni islem
    # tekrarlanacaksa Scenario Outline harika bir yöntem.
    # Scenario Outline' da Examples icindeki her bir satir icin ayri bir Scenario calisiyor gibi de düsünebiliriz
    # Bosluklari düzenleme ile ilgili kisayol: Ctrl+ Alt + L

  Scenario Outline: a basic summary as an example
    Given "<firstnumber>" plus "<secondnumber>" plus "<thirdnumber>"
    Then plus "<fourthnumber>"
    Examples: numbers for summary
      | firstnumber | secondnumber | thirdnumber | fourthnumber |
      | 23          | 12           | 20          | 67           |
      | 44          | 7            | 9           | 3            |
      | 150         | 715          | 11          | 32           |

    # Scenario ile birlikte de Datatable 'lar yazilabilir.
    # Example olusturma zorunlulugu yoktur, Datatable'dan sonra adim yazilabilir.
    # Eger ayni sayfa üzerinde farkli degerlerle browser'i kapatip tekrar testi baslatmaya gerek olmayan testlerde
    # bu yöntemi kullanabiliriz.
    # Bosluklari düzenleme ile ilgili kisayol: Ctrl+ Alt + L

  Scenario: is user able to login
    Given using Datatables
      | user1 | password1 |
      | user2 | password2 |
    Then what about a new  user and password