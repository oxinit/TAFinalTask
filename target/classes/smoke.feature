Feature: FeatureTask
  As a user
  I want to make some ACTION
  So that I can achieve a goal
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check Sign-in from main page and checks reaction on wrong email input
    Given User open '<homePage>' page
    When User click 'All' button popup element
    And User click 'Sing in' button from popup panel
    Then User check 'Sign in' label visibility
    Then User fill email field with '<keyword>'
    And User click 'Continue' button
    Then User must see error box popup
    And User check error Text are '<errorText>'


    Examples:
      | homePage               | keyword | errorText |
      | https://www.amazon.com | cake    | There was a problem                |

  Scenario Outline: Check widget functionality
    Given User open '<homePage>' page
    Then User click left arrow button on widget below search
    And User check does widget changed image
    Then User click right arrow button
    And User check does widget have original image

    Examples:
      | homePage               |
      | https://www.amazon.com |

    Scenario Outline: user try add to cart a product from category for home aka amazonbasics
      Given User open '<homePage>' page
      When User click on image of for home category
      And User click on first from list
      Then User click add to cart button
      And User check does product'<Inscription>'match

      Examples:
        | homePage               |Inscription|
        | https://www.amazon.com |Added to Cart|

      Scenario Outline:user search amazonbasics via search field and add to cart product
        Given User open '<homePage>' page
        When User fill search field with '<Search text>'
        Then User click find button
        And User click on second element from list
        Then User click add to cart button
        And User check does product'<Inscription>'match
        Examples:
          | homePage               |Search text|Inscription|
          | https://www.amazon.com |amazonbasics|Added to Cart|
        Scenario Outline:Check widget functionality and multi products in cart
        Given User open '<homePage>' page
          When User click on widget below search
          And user must see inscription Featured Categories
          Then user click on chairs category
          And user starting add first <amount> elements to cart and get back to'<GamingChairsPage>'
          Then user check '<amount>' of products in cart
          Examples:
            | homePage               |GamingChairsPage|amount|
            | https://www.amazon.com |https://www.amazon.com/s?k=gaming+chairs&pf_rd_i=23508887011&pf_rd_m=ATVPDKIKX0DER&pf_rd_p=434db2ed-6d53-4c59-b173-e8cd550a2e4f&pf_rd_r=QT9GCTV0JE426P34XSYP&pf_rd_s=merchandised-search-5&pf_rd_t=101&ref=nb_sb_noss|3|
  Scenario Outline:Product test
    Given User open '<ProductPage>' page
    When User check visibility of product image
    And User check visibility of product price
    And User check in Stock Inscription
    Then User click add to cart button
    And User check does product price match to price in cart


    Examples:
      | ProductPage           |
      | https://www.amazon.com/dp/B07B64T9B3?psc=1&pf_rd_p=b9c4a2ec-084b-4239-9a34-c9686515e635&pf_rd_r=852ARAF10SA8PMYS05EC&pd_rd_wg=Ni1Xa&pd_rd_i=B07B64T9B3&pd_rd_w=aci6I&pd_rd_r=4436fed4-f32d-45ec-b519-48c6ad6ec1d6&ref_=pd_luc_rh_tsdvd_crc_04_04_t_img_lh |
      | https://www.amazon.com/dp/B07TV8M755/ref=sspa_dk_detail_0?psc=1&pd_rd_i=B07TV8M755&pd_rd_w=jNBGc&pf_rd_p=91afecf5-8b2e-41e2-9f11-dc6992c6eaa1&pd_rd_wg=rNbXu&pf_rd_r=3BMRBPMKMVNJ0DJC6WAR&pd_rd_r=26714370-a15e-4665-93ae-87c8c9f45e2b&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFaM09ZOUw1NE5SMU8mZW5jcnlwdGVkSWQ9QTA4NzYwNTAxRU1aMzg2SUxGSzlKJmVuY3J5cHRlZEFkSWQ9QTAwMDUzNDMzNUlUTlBMU1NHMFZFJndpZGdldE5hbWU9c3BfZGV0YWlsJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==|
      |https://www.amazon.com/Amazon-Basics-Shaggy-Sherpa-Blanket/dp/B08FTMMZTN/ref=pd_mrai_hpb_ps_hpb_3/135-5741802-4032366?pd_rd_w=QWsOF&pf_rd_p=b54e0907-a629-4ef9-8ae9-4bf98ae93e45&pf_rd_r=X6GR3CJ88HJ9G4627DRT&pd_rd_r=eaa8979b-8170-43fd-bdeb-08d15c7f7102&pd_rd_wg=BWjSJ&pd_rd_i=B08FTMMZTN&psc=1                                                                                                                                                                       |

  Scenario Outline:appropriate query form search field
    Given User open '<homePage>' page
    When User fill search field with '<Search text>'
    And User click find button
    Then User check query generated '<Search text>'
    Examples:
      | homePage               |Search text|
      | https://www.amazon.com |12-354984sd12426SADff****|
      | https://www.amazon.com |Added to Cart|
      | https://www.amazon.com |Blah blah bla|
      | https://www.amazon.com/Amazon-Basics-Shaggy-Sherpa-Blanket/dp/B08FTMMZTN/ref=pd_mrai_hpb_ps_hpb_3/135-5741802-4032366?pd_rd_w=QWsOF&pf_rd_p=b54e0907-a629-4ef9-8ae9-4bf98ae93e45&pf_rd_r=X6GR3CJ88HJ9G4627DRT&pd_rd_r=eaa8979b-8170-43fd-bdeb-08d15c7f7102&pd_rd_wg=BWjSJ&pd_rd_i=B08FTMMZTN&psc=1|Hellp|

  Scenario Outline: try use help as not signed user
    Given User open '<homePage>' page
    When User check help button visibility
    Then User click help button
    And User check Help Category Boxes visibility
    Then User click Returns&Refunds category
    And User check Sign in box visibility
    Examples:
  | homePage               |
  | https://www.amazon.com |

  Scenario Outline: language change lookout
    Given User open '<homePage>' page
    When User click language button
    Then User click Spanish language check box
    And User check inscription nearby
    Then User click Deutsch language check box
    And User check inscription according to language
    And User returns to English language using check box
    Then User click Save Changes button
    And User chek main page inscriptions for English language
    Examples:
      | homePage               |
      | https://www.amazon.com |

  Scenario Outline: language change lookout
    Given User open '<homePage>' page
    Then User checks does cart empty
    Examples:
      | homePage               |
      | https://www.amazon.com |
