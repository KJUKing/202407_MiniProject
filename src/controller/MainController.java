package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import service.BookingService;
import service.MemberService;
import service.MovieService;
import service.ScheduleService;
import service.SeatService;
import service.TicketService;
import util.ScanUtil;
import view.DelayUtil;
import view.Print;
import view.View;
import vo.BookingVo;
import vo.MemberVo;
import vo.MovieVo;
import vo.ScheduleVo;
import vo.SeatVo;
import vo.TicketVo;

public class MainController extends Print {
   static public Map<String, Object> sessionStorage = new HashMap<>();
   // 프리서비스랑 연결
   MovieService movieService = MovieService.getInstance();
   ScheduleService scheduleService = ScheduleService.getInstance();
   SeatService seatService = SeatService.getInstance();
   MemberService memberService = MemberService.getInstance();
   BookingService bookingService = BookingService.getInstance();


   TicketService ticketService = TicketService.getInstance();

   public static void main(String[] args) {
      new MainController().start(); // 시작
   }

   private void start() {
      View view = View.MAIN; // MAIN 1
      while (true) {
         switch (view) {
            case MAIN:
               view = main();
               break;
            case LOGIN:
               view = login();
               break;
            case SIGN_UP:
               view = signUp();
               break;
            case ADMIN:
               view = admin();
               break;
            case MOVIE_LIST:
               view = movieList();
               break;
            case MOVIE_DETAIL:
               view = movieDetail();
               break;
            case SCHEDULE:
               view = schedule();
               break;
            case SCHEDULE_DETAIL:
               view = scheduleDetail();
               break;
            case SEAT:
               view = seat();
               break;
            case BOOKING:
               view = booking();
               break;
            case TICKET_BUY:
               view = ticketBuy();
               break;
            case MEMBER_DETAIL:
               view = memberDetail();
               break;
            case MEMBER_UPDATE:
               view = memberUpdate();
               break;
            case MEMBER_DELETE:
               view = memberDelete();
               break;
            case TICKET_CHECK:
               view = ticketCheck();
               break;

            default:
               break;
         }
      }
   }

   // 예매티켓 삭제
   private void ticketDelete(int input) {
      List<Object> param = new ArrayList<>();
      param.add(input);
      TicketVo bk = ticketService.ticketDelBeforeSel(param);
      int bkCode = (int)bk.getFk_bk_code();
      ticketService.ticketDelete(param);
      param.clear();
      param.add(bkCode);
      BookingVo st = bookingService.bookingDelBeforeSel(param);
      String seatCode = st.getFk_seat_code();
      bookingService.bookingTicketDelete(param);
      param.clear();
      param.add(seatCode);
      seatService.seatStatusUpdate(param);

   }


   // 예매내역확인
   private View ticketCheck() {
      List<Object> param = new ArrayList<>();
      String id = (String) sessionStorage.get("id");
      param.add(id);
      List<MemberVo> memberVos = ticketService.ticketCheck(param);
      if (memberVos.isEmpty()) {
         ticketEmptyPrint();
         return View.MEMBER_DETAIL;
      }

      // 영화 코드를 중복없이 저장하기위한 Set
      Set<String> movieCodes = new HashSet<>();
      for (MemberVo memberVo : memberVos) {
         movieCodes.add(memberVo.getMovie_code());
      }

      // 각 영화코드 상세정보 도출
      List<MemberVo> ticketResult = new ArrayList<>();
      for (String movieCode : movieCodes) {
         param.clear();
         param.add(id);
         param.add(movieCode);
         List<MemberVo> result = ticketService.ticketCheckList(param);
         ticketResult.addAll(result); // 전체 출력
      }

//	      List<Object> infoList = new ArrayList<>();
      String memNick = null;
      int totalPrice = 0;
      List<Integer> ticketList = new ArrayList<Integer>();
      var1PrintLn();
      printLn(3);
      for (MemberVo memberVo : ticketResult) {
         memNick = memberVo.getMem_nick();

         String movieName = memberVo.getMovie_name();
//	               String genre = memberVo.getGenre();
         String partType = memberVo.getPart_type();
         String runningTime = memberVo.getRunning_time();
         String rowNum = memberVo.getRow_num();
         int seatNum = memberVo.getSeat_num();
         int price = memberVo.getPrice();
         String theName = memberVo.getThe_name();
         int ticket = memberVo.getTicket();
         ticketList.add(ticket);
         ticketDetail(movieName, runningTime, rowNum, seatNum, theName, partType, ticket);

         totalPrice += price;
         System.out.println(); // 줄바꿈 구분
      }
      spacePrint2();
      System.out.println("      "+memNick + "님의 총 결제금액 내역 : " + totalPrice + "원 입니다");
      System.out.println();
//	      var();
//	      System.out.println("1. 예매내역 취소하기");
//	      System.out.println("2. 마이페이지로 돌아가기");
      ticketCheckPrint();
      menuPrint();
      int input = 0;
      int sel = ScanUtil.menu();
      switch (sel) {
         case 1:
            boolean validTicket = false;
            while(!validTicket) {
               printLn(1);
               spacePrint1();
               System.out.println("0번 : 뒤로가기");
               spacePrint1();
               input = ScanUtil.nextInt("취소할 티켓 번호를 입력해주십시오 : ");
               if(input ==0) {
                  return View.MEMBER_DETAIL;
               }

               if(!ticketList.contains(input)) {
                  printLn(1);
                  spacePrint2();
                  System.out.println("     [  없는 티켓 번호입니다 다시 입력해주세요  ]");
                  DelayUtil.delay(2000);
                  printLn(3);
               } else {
                  validTicket = true;
               }
            }
            ticketDelete(input);
            ticketCancelPrint();
            return View.TICKET_CHECK;
         case 2:
            return View.ADMIN;
         default:
            errorIssuePrint();
//	           System.out.println("잘못된 입력값입니다 다시 입력해주십시오");
            return View.TICKET_CHECK;
      }
   }

   private View memberDelete() {
      MemberVo member = (MemberVo) sessionStorage.get("member");
      int memNo = member.getMem_no();
      List<Object> param = new ArrayList<>();
      param.add(memNo);
      memberDelte();
//      System.out.println("정말 탈퇴하시겠습니까?");
//      System.out.println("1. 네");
//      System.out.println("2. 아니오");
      menuPrint();
      int sel = ScanUtil.menu();

      if (sel > 2 || sel < 1) {
         errorIssuePrint();
//         System.out.println("잘못된 입력값입니다 다시 입력해주십시오");
         return View.MEMBER_DELETE;
      }
      if (sel == 1) {
         memberService.memberDelete(param);
         printLn(3);
         spacePrint1();
         System.out.println("[  탈퇴하였습니다 이용해주셔서 감사합니다  ]");
         System.out.println("[  3초후 초기 화면으로 이동합니다  ]");
         DelayUtil.delay(3000);
         printLn(3);
         return View.MAIN;
      }
      if (sel == 2) {
         printLn(3);
         spacePrint1();
         System.out.println("[  마이페이지로 이동합니다  ]");
         DelayUtil.delay(2000);
         printLn(3);
         return View.MEMBER_DETAIL;
      }
      return View.MEMBER_DELETE;
   }

   private View memberUpdate() {
      MemberVo member = (MemberVo) sessionStorage.get("member");
      int memNo = member.getMem_no();
      memberUpdatePrint();
//      System.out.println("개인정보 변경 페이지입니다");
//      System.out.println("바꾸실 정보를 입력해주세요");
//      System.out.println();
//      System.out.println("1. 닉네임");
//      System.out.println("2. 비밀번호");
//      System.out.println("3. 전체");
//      System.out.println("4. 마이페이지로");
      menuPrint();
      int sel = ScanUtil.menu();
      if (sel > 4 || sel < 1) {
         errorIssuePrint();
//         System.out.println("잘못된 입력값입니다 다시 입력해주십시오");
         return View.MEMBER_UPDATE;
      }
      if (sel == 4) {
         return View.MEMBER_DETAIL;
      }
      List<Object> param = new ArrayList<>();
      if (sel == 1 || sel == 3) {
         spacePrint1();
         String nickname = ScanUtil.nextLine("수정할 닉네임 : ");
         param.add(nickname);
      }
      if (sel == 2 || sel == 3) {
         spacePrint1();
         String password = ScanUtil.nextLine("수정할 비밀번호 : ");
         param.add(password);
      }
      param.add(memNo);

      memberService.memberUpdate(param, sel);
      MainController.sessionStorage.clear();
      sessionStorage.put("view", View.MEMBER_DETAIL);
      memberUpdateCompletePrint();
//      System.out.println("개인정보가 수정되었습니다. 다시 로그인해주십시오");
//      System.out.println();
      return View.MAIN;
   }

   private View memberDetail() {
      MemberVo member = (MemberVo) sessionStorage.get("member");

      String memName = member.getMem_name();
      String memId = member.getMem_id();
      String memPass = member.getMem_pass();
      String memBir = member.getMem_bir();
      String memNick = member.getMem_nick();
      memberDetailPrint(memName, memId, memPass, memBir, memNick);
      menuPrint();
      int sel = ScanUtil.menu();
      switch (sel) {
         case 1:
            return View.MEMBER_UPDATE;
         case 2:
            return View.MOVIE_LIST;
         case 3:
            return View.TICKET_CHECK;
         case 4:
            spacePrint1();
            System.out.println("[  로그아웃되었습니다  초기화면으로 이동합니다]");
            DelayUtil.delay(2000);
            sessionStorage.clear();
            return View.MAIN;
         case 5:
            return View.MEMBER_DELETE;
         default:
            spacePrint1();
            System.out.println("[  잘못된 입력값입니다 다시 입력해주십시오  ]");
            DelayUtil.delay(2000);
            return View.MEMBER_DETAIL;
      }
   }

   // 예매예약 취소
   private void bookingDelete(int bkCode) {
      List<Object> paramBk = new ArrayList<Object>();
      paramBk.add(bkCode);
      bookingService.bookingDelete(paramBk);
   }

   private void bookingDelete1(int bkCode1, int bkCode2) {
      List<Object> paramBk = new ArrayList<Object>();
      paramBk.add(bkCode1);
      paramBk.add(bkCode2);
      bookingService.bookingDelete1(paramBk);
   }

   private void seatDelete(String seatCode) {
      List<Object> paramSt = new ArrayList<Object>();
      paramSt.add(seatCode);
      seatService.seatDelete(paramSt);
   }

   private void seatDelete1(String seatCode1, String seatCode2) {
      List<Object> paramSt = new ArrayList<Object>();
      paramSt.add(seatCode1);
      paramSt.add(seatCode2);
      seatService.seatDelete1(paramSt);
   }

   //티켓 취소하기
   private void cancelTicket(int bookingSel) {
      if (bookingSel == 1) {
         int bkCode = (int) sessionStorage.get("bkCode");
         bookingDelete(bkCode);
      }
      if (bookingSel == 2) {
         int bkCode1 = (int) sessionStorage.get("bkCode1");
         int bkCode2 = (int) sessionStorage.get("bkCode2");
         bookingDelete1(bkCode1, bkCode2);
      }
   }

   //선택한 영화 및 금액 정보출력
   private void printMovieInfo(MovieVo movie, int bookingSel) {
      String movieName = movie.getMn(); // 영화제목
      String genre = movie.getGn(); // 장르
      String partType = movie.getPart_type(); // 관람가
      String thName = movie.getTn(); // 상영관
      int price = movie.getPr(); // 가격
      movieInfoPrint();
      spacePrint1();
      if (bookingSel == 1) System.out.println("결제금액 : " + price);       //1명 결제
      if (bookingSel == 2) System.out.println("결제금액 : " + price * 2);   //2명 결제
   }

   private void purchaseTicket(int bookingSel, int paySel, int price) {

      int memNo = (int) sessionStorage.get("memNo");
      List<Object> paramTk = new ArrayList<>();
      List<Object> paramBk = new ArrayList<>();
      paramTk.add(memNo);

      if (bookingSel == 1) {
         int bkCode = (int) sessionStorage.get("bkCode");
         paramTk.add(bkCode);
         paramTk.add(paySel);
         paramTk.add(price);
         paramBk.add(bkCode);
         ticketService.tkInsert(paramTk);
         bookingService.bkCheckUpdate(paramBk);
         // bk코드로 업데이트문으로 update
      } else if (bookingSel == 2) {
         int bkCode1 = (int) sessionStorage.get("bkCode1");
         int bkCode2 = (int) sessionStorage.get("bkCode2");
         paramTk.add(bkCode1);
         paramTk.add(paySel);
         paramTk.add(price);
         paramTk.add(memNo);
         paramTk.add(bkCode2);
         paramTk.add(paySel);
         paramTk.add(price);
         paramBk.add(bkCode1);
         paramBk.add(bkCode2);
         ticketService.tkInsert1(paramTk);
         bookingService.bkCheckUpdate1(paramBk);
      }
   }
   // 티켓구매
   private View ticketBuy() {
      int selMovie = (int) sessionStorage.get("movieNo");
      List<Object> param = new ArrayList<>();
      param.add(selMovie);

      MovieVo movie = movieService.ticketSelect(param);        //movie정보 추출

      int bookingSel = (int) sessionStorage.get("bookingSel");
      printMovieInfo(movie, bookingSel);                       //영화 정보 및 최종금액 출력
      ticketBuyPrint();
//      System.out.println("결제확인 창입니다");
//      System.out.println("================================");
//      System.out.println("결제하실 방법을 선택하세요");
//      System.out.println("1. 카드");
//      System.out.println("2. 현금");
//      System.out.println("3. 문화상품권");
//      System.out.println("4. 예매취소");
      menuPrint();
      int paySel = ScanUtil.menu();
      if (paySel > 4 || paySel < 1) {
         printLn(1);
         spacePrint2();
         System.out.println("[  잘못된 입력값입니다 다시 입력해주십시오  ]");
         DelayUtil.delay(2000);
         printLn(3);
         return View.TICKET_BUY;
      }
      if (paySel == 4) {
         cancelTicket(bookingSel); //티켓 취소 메소드 호출
         return View.MOVIE_LIST;
      }

      purchaseTicket(bookingSel, paySel, movie.getPr()); //1. 일전에고른 번호, 2. 결제방식, 3. 가격
      thankPrint();
      return View.ADMIN;
   }

   //예약 좌석까지 기입후 장바구니에 넣는 메소드
   private void updateBooking(int bookingSel) {
      if (bookingSel == 1) {
         String schCode = (String) sessionStorage.get("sch");
         String seatCode = (String) sessionStorage.get("seatCode");
         List<Object> paramBk = new ArrayList<>();
         paramBk.add(schCode);
         paramBk.add(seatCode);
         bookingService.bookingUpdate(paramBk);
         BookingVo booking = bookingService.bookingSelect(paramBk);
         System.out.println(booking.getBk_code());
         sessionStorage.put("bkCode", booking.getBk_code()); // bkCode
         //인라인 메소드
      }
      if (bookingSel == 2) {
         String schCode = (String) sessionStorage.get("sch");
         String seatCode1 = (String) sessionStorage.get("seatCode1");
         String seatCode2 = (String) sessionStorage.get("seatCode2");
         List<Object> paramBk = new ArrayList<>();
         paramBk.add(schCode);
         paramBk.add(seatCode1);
         paramBk.add(schCode);
         paramBk.add(seatCode2);
         bookingService.bookingUpdate1(paramBk);
         List<BookingVo> bookings = bookingService.bookingSelectList(paramBk);
         sessionStorage.put("bkCode1", bookings.get(0).getBk_code());
         sessionStorage.put("bkCode2", bookings.get(1).getBk_code()); // 한번에 파라미터값을 보내기
         // 여기서 List<BookingVo>로 bk_code 값을 받아와서 두개값을 다 담아야함
      }
   }

   private void cancelBooking(int bookingSel) {
      if (bookingSel == 1) {
         int bkCode = (int) sessionStorage.get("bkCode");
         bookingDelete(bkCode);
         String seatCode = (String) sessionStorage.get("seatCode");
         seatDelete(seatCode);
      }
      if (bookingSel == 2) {
         int bkCode1 = (int) sessionStorage.get("bkCode1");
         int bkCode2 = (int) sessionStorage.get("bkCode2");
         bookingDelete1(bkCode1, bkCode2);
         String seatCode1 = (String) sessionStorage.get("seatCode1");
         String seatCode2 = (String) sessionStorage.get("seatCode2");
         seatDelete1(seatCode1, seatCode2);
      }
   }

   // 예매내역확인
   private View booking() {
      MovieVo movie = (MovieVo) sessionStorage.get("movie");
      String seat = (String) sessionStorage.get("seat");
      String movieName = movie.getMovie_name();
      sessionStorage.put("movieName", movieName); // 선택한 영화이름
      String genre = movie.getGenre();
      String rateType = movie.getRATETYPE();

      int bookingSel = (int) sessionStorage.get("bookingSel");
      updateBooking(bookingSel); // 업데이트하는 메소드 *메소드가 너무 길어서 메소드 추출
      bookingPrint(movieName, genre, rateType, seat);
//      System.out.println("영화 제목 : " + movieName + "\n장르 : " + genre + " 관람가 : " + rateType);
//      System.out.println("좌석번호 : " + seat);
//      System.out.println("1. 결제하기");
//      System.out.println("2. 메인으로 돌아가기");
      menuPrint();
      int sel = ScanUtil.menu();
      switch (sel) {
         case 1:
            return View.TICKET_BUY;
         case 2:
            cancelBooking(bookingSel); //예약 취소 메소드 호출
            return View.ADMIN;
         default:
            spacePrint2();
            System.out.println("[  잘못된 입력값입니다  ]");
            DelayUtil.delay(2000);
            printLn(3);
            return View.BOOKING;
      }
   }

   private View seat() {
      View view = null;
      String th = (String) sessionStorage.get("th");
      List<Object> param1 = new ArrayList<>();
      param1.add(th);
      List<SeatVo> seat = seatService.seatList(param1);
      int max = 0;
      for (SeatVo seatVo : seat) {
         max = seatVo.getSeat_max();                                         // 영화관의 좌석수 추출
      }
      if (max == 20) {
         displaySeats(seat, 5, new String[]{"A","B","C","D"});       // 20좌석의 영화관 예매시
      } else {
         displaySeats(seat, 6, new String[]{"A","B","C","D","E"});   // 30좌석의 영화관 예매시
      }
      System.out.println();
      menuPrint();
      spacePrint1();
      int sel = ScanUtil.nextInt("예매 인원을 선택해주세요(1~2) : ");
      List<Object> param = new ArrayList<Object>();
      sessionStorage.put("bookingSel", sel); // 예매인원
      if (sel == 1) {
         singleSeatSelect(max, param, th);                                   //한명예매시 한좌석예매 메소드 호출
      } else if (sel == 2) {
         doubleSeatSelect(max, param, th);                                   //두명예매시 두좌석좌석예매 메소드 호출
      } else {
         spacePrint2();
         System.out.println("[  잘못된 인원을 입력하셨습니다 다시 입력해주세요  ]");
         DelayUtil.delay(2000);
         return View.SEAT;
      }
      sessionStorage.containsKey("view");
      view = (View) sessionStorage.get("view");
      return view;
   }

   //두명의 좌석 예약 입력
   // View반환에서 void로 변경
   private void doubleSeatSelect(int max, List<Object> param, String th) {

      String row1 = null;
      int seatNum1 = 0;
      String row2 = null;
      int seatNum2 = 0;
      boolean validInput1 = false;
      boolean validInput2 = false;

      while (!validInput1 || !validInput2) {
         if (max == 20) {
            spacePrint1();
            row1 = ScanUtil.nextLine("좌석 열을 선택해주세요 A~D : ").toUpperCase();
            spacePrint1();
            seatNum1 = ScanUtil.nextInt("좌석 번호를 선택해주세요 1~5 : ");
            validInput1 = validateSeat(row1, seatNum1, 4, 5);
            spacePrint1();
            row2 = ScanUtil.nextLine("좌석 열을 선택해주세요 A~D : ").toUpperCase();
            spacePrint1();
            seatNum2 = ScanUtil.nextInt("좌석 번호를 선택해주세요 1~5 : ");
            validInput2 = validateSeat(row2, seatNum2, 4, 5);
         } else {
            spacePrint1();
            row1 = ScanUtil.nextLine("좌석 열을 선택해주세요 A~E : ").toUpperCase();
            spacePrint1();
            seatNum1 = ScanUtil.nextInt("좌석 번호를 선택해주세요 1~6 : ");
            validInput1 = validateSeat(row1, seatNum1, 5, 6);
            spacePrint1();
            row2 = ScanUtil.nextLine("좌석 열을 선택해주세요 A~E : ").toUpperCase();
            spacePrint1();
            seatNum2 = ScanUtil.nextInt("좌석 번호를 선택해주세요 1~6 : ");
            validInput2 = validateSeat(row2, seatNum2, 5, 6);
         }
         if (!validInput1 || !validInput2) {
            printLn(1);
            spacePrint2();
            System.out.println("[  잘못된 입력값입니다. 다시 입력해주세요  ]");
            DelayUtil.delay(2000);
            printLn(3);
         }
      }
      param.add(row1); // 파라미터 값 추가
      param.add(seatNum1);
      param.add(row2);
      param.add(seatNum2);
      param.add(th);

      if (!confirmEqualsSeat(row1, row2, seatNum1, seatNum2)) {
         printLn(1);
         spacePrint2();
         System.out.println("[  선택한 자리가 같은 자리입니다. 다시 선택해주십시오  ]");
         DelayUtil.delay(2000);
         printLn(3);
         sessionStorage.put("view", View.SEAT);
      }
      else if(!confirmDoubleSeat(param)) {
         printLn(1);
         spacePrint2();
         System.out.println("[  이미 예약된 자리입니다. 다시 선택해주십시오  ]");
         DelayUtil.delay(2000);
         printLn(3);
         sessionStorage.put("view", View.SEAT);
      }
      else {
         seatService.seat1(param);
         sessionStorage.put("seat", row1 + seatNum1 + ", " + row2 + seatNum2);

         List<SeatVo> seatInfo1 = seatService.seatInfo1(param); //파라미터값 시트info입력

         ArrayList<String> arr1 = new ArrayList<>();
         for (SeatVo seatVo : seatInfo1) { // seatVo값뽑기
            String seatCode = seatVo.getSeat_code();
            arr1.add(seatCode);
         }
         String seatCode1 = arr1.get(0);
         String seatCode2 = arr1.get(1);
         sessionStorage.put("seatCode1", seatCode1);
         sessionStorage.put("seatCode2", seatCode2);
         sessionStorage.put("view", View.BOOKING);
      }
   }
   private boolean confirmEqualsSeat(String row1, String row2, int seatNum1, int seatNum2) {
      if(row1.equals(row2) && seatNum1 == seatNum2) {
         return false;
      }
      return true;
   }
   // 한명의 인원 좌석 예약
   // View반환에서 void로 변경
   private void singleSeatSelect(int max, List<Object> param, String th) {
      String row1 = null;
      int seatNum1 = 0;
      boolean validInput = false; // 기본값 false

      while (!validInput) {
         if (max == 20) { //20좌석 상영관
            spacePrint1();
            row1 = ScanUtil.nextLine("좌석 열을 선택해주세요 A~D : ").toUpperCase();
            spacePrint1();
            seatNum1 = ScanUtil.nextInt("좌석 번호를 선택해주세요 1~5 : ");
            validInput = validateSeat(row1, seatNum1, 4, 5);
         } else { //30좌석 상영관
            spacePrint1();
            row1 = ScanUtil.nextLine("좌석 열을 선택해주세요 A~E : ").toUpperCase();
            spacePrint1();
            seatNum1 = ScanUtil.nextInt("좌석 번호를 선택해주세요 1~6 : ");
            validInput = validateSeat(row1, seatNum1, 5, 6);
         }
         if (!validInput) {
            printLn(1);
            spacePrint2();
            System.out.println("[  잘못된 입력값입니다. 다시 입력해주세요  ]");
            DelayUtil.delay(2000);
            printLn(3);
         }
      }
      param.add(row1);
      param.add(seatNum1);
      param.add(th);
      confirmSeat(param);
//      seatService.seat(param);
      sessionStorage.put("seat", row1 + seatNum1); //좌석 기입 a1, b4 등
      SeatVo seatInfo = seatService.seatInfo(param);
      String seatCode = seatInfo.getSeat_code();
      sessionStorage.put("seatCode", seatCode); //완성된 seat코드 기입
   }
   private void confirmSeat(List<Object> param) {
      SeatVo seatVo = seatService.reserveSeat(param);
      if("Y".equals(seatVo.getStatus())) {
         printLn(1);
         spacePrint2();
         System.out.println("[  이미 예약된 자리입니다. 다시 선택해주십시오  ]");
         DelayUtil.delay(2000);
         printLn(3);
         sessionStorage.put("view", View.SEAT);
      }else {
         seatService.seat(param);
         sessionStorage.put("view", View.BOOKING);
      }
   }
   private boolean confirmDoubleSeat(List<Object> param) {
      List<SeatVo>seateVo = seatService.reserveSeat1(param);
      List<Object>status = new ArrayList<Object>();
      for (SeatVo seatVo2 : seateVo) {
         status.add(seatVo2.getStatus());
      }

      if("Y".equals(status.get(0))||"Y".equals(status.get(1))) {
         return false;
      }
      return true;

   }
   // 영화관 자리 리스트 출력
   private void displaySeats(List<SeatVo> seat, int columns, String[] rows) {
      Set<String> uniqueRows = new HashSet<>(); // SET으로 중복제거목적 A,A,A .. D,D,D 등등
      String[] arr = new String[50];
      int cnt = 0;
      int cnt1 = 0; // 현재 행의 인덱스를 추적하는 변수

      scheduleDetailPrint1();
      System.out.print("\t\t\t\t\t\t\t\t  ");
      for (int i = 1; i <= columns; i++) {
         System.out.print(i + "  "); // 좌석 번호 출력
      }
      System.out.println();

      for (int i = 0; i < seat.size(); i++) {
         SeatVo seatVo = seat.get(i);
         String rowNum = seatVo.getRow_num();
         uniqueRows.add(rowNum); // 값담기

         arr[i] = seatVo.getStatus();

         if (cnt % columns == 0) {
            spacePrint1();
            System.out.print(rows[cnt1] + " "); // 행 이름 출력
         }

         if (arr[i].equals("Y")) {
            System.out.print("■  ");
         } else {
            System.out.print("□  ");
         }

         cnt++;

         if (cnt % columns == 0) {
            System.out.println(); // 다음 행으로 넘어가기
            cnt1++; // 다음 행으로 이동
         }
      }
   }

   // seat 오류 검증
   private boolean validateSeat(String row, int seatNum, int maxRows, int maxCols) {
      return row.length() == 1 && row.charAt(0) >= 'A' && row.charAt(0) <= 'A' + maxRows && seatNum >= 1 && seatNum <= maxCols;
   }

   //이 로직에서는 콘솔에 출력되지않고 각각 시간값과 영화코드값이 입력되고 바로 SEAT로직으로 넘어감
   private View scheduleDetail() {
      int timeCode = (int) sessionStorage.get("timeCode");
      String movieCode = (String) sessionStorage.get("movieCode");

      List<Object> param = new ArrayList<Object>();
      param.add(timeCode);
      param.add(movieCode);
      scheduleDetailPrint();
//      var();
//      System.out.println("좌석선택 페이지");
      ScheduleVo scheduleVo = scheduleService.scheduleDetail(param);
      String th = scheduleVo.getFk_the_code();
      String sch = scheduleVo.getSch_code();
      sessionStorage.put("th", th);
      sessionStorage.put("sch", sch);

      return View.SEAT;
   }

   private View schedule() {
      int movieNo = (int) sessionStorage.get("movieNo");
      List<Object> param = new ArrayList<>();
      param.add(movieNo);
      List<ScheduleVo> schedule = scheduleService.schedule(param);
      schedulePrint();
//      System.out.println("\t\t\t상영번호\t1TIME\t\t2TIME\t\t3TIME\t\t4TIME\t\t5TIME\t\t6TIME");
//      System.out.print("\t\t\t러닝타임");
      for (ScheduleVo scheduleVo : schedule) {
         String runningTime = scheduleVo.getRunning_time();
         System.out.print("\t" + runningTime);
      }
      System.out.println();
      var();
      printLn(1);
      spacePrint1();
      int sel = ScanUtil.nextInt("상영시간을 선택해 주십시오 : ");
      if (sel > 6 || sel < 1) {
         printLn(1);
         spacePrint2();
         System.out.println("[  없는 시간대 번호입니다 다시 입력해주십시오  ]");
         DelayUtil.delay(2000);
         printLn(3);
         return View.SCHEDULE;
      }
      sessionStorage.put("timeCode", sel); // time_code - 1번클릭시 09:00등등

      return View.SCHEDULE_DETAIL;
   }

   // 상세영화조회
   private View movieDetail() {
      int movieNo = (int) sessionStorage.get("movieNo"); // 선택한 상세영화번호

      List<Object> param = new ArrayList<>();
      param.add(movieNo);                                // movieList에서 골랐던 번호파라미터 입력
      MovieVo movie = movieService.movieDetail(param);
      String movieName = movie.getMovie_name();
      String genre = movie.getGenre();
      String rateType = movie.getRATETYPE();
      String movieCode = movie.getMovie_code();          // 하나의 영화 정보를 전체출력
      sessionStorage.put("movieCode", movieCode);
      sessionStorage.put("movie", movie);
      switch (movieNo) {
         case 1:movieDetailPrint1(movieName, genre, rateType);
            break;
         case 2:movieDetailPrint2(movieName, genre, rateType);
            break;
         case 3:movieDetailPrint3(movieName, genre, rateType);
            break;
         case 4:movieDetailPrint4(movieName, genre, rateType);
            break;
      }
//      System.out.println("영화제목\t\t장르\t  관람가");
//      System.out.println(movieName + "\t" + genre + "\t  " + rateType);
//      System.out.println("1. 영화스케쥴 조회");
//      System.out.println("2. 영화리스트(뒤로가기)");
      int sel = ScanUtil.menu();
      printLn(1);
      switch (sel) {
         case 1:
            return View.SCHEDULE;
         case 2:
            return View.MOVIE_LIST;
         default:
            spacePrint2();
            System.out.println("[  잘못 입력하셨습니다 다시 입력해주십시오  ]");
            DelayUtil.delay(2000);
            return View.MOVIE_DETAIL;
      }
   }

   //나이체크 메소드를 movieList에서 검증하도록 booking메소드에서 추출 및 이전 07.16
   private boolean ageCheck(String id, int rateCode) {
      List<Object> param = new ArrayList<>();
      param.add(id);                                              //나이체크를 위한 멤버의 파라미터값 도출
      param.add(rateCode);

      MemberVo mem = memberService.ageCheck(param);               //나이제한 체크에대한 dao실행 -> dao에서 확인
      return mem.getOk() == 1;                                    //1만 참값 그외 거짓
   }

   // 무비 리스트
   private View movieList() {
      MemberVo member = (MemberVo) sessionStorage.get("member");
      String memName = member.getMem_name();                      //나이체크용 이름 추출
      String id = (String) sessionStorage.get("id");
      List<MovieVo> movieList = movieService.movieList();
      movieListPirnt();
//      var();
//      System.out.println("번호\t영화제목\t\t\t장르\t\t관람가\t     상영관");
//      System.out.print("\t\t\t");
      for (MovieVo movieVo : movieList) {
         String movieNo = movieVo.getMono();
         String movieName = movieVo.getMn();
         String genre = movieVo.getGn();
         String thName = movieVo.getTn();
         String partType = movieVo.getPart_type();
         // 출력할필요는 없어서 넣지는않았지만 select 조회로 getFk_rate 값도 갖고오고있음
         System.out.print("\t\t\t\t");
         System.out.println("\t"+movieNo + "\t" + movieName + "\t\t" + genre + "\t\t" + partType + "     " + thName);
      }
      movieListReturnPrint();
//      System.out.println("5   뒤로가기");
      spacePrint1();
      int sel = ScanUtil.nextInt("상세조회 할 영화의 번호를 입력해주세요 : ");
      sessionStorage.put("movieSel", sel);
      if (sel == 5) {
         return View.ADMIN;
      } else if (sel > 5 || sel < 1) {
         printLn(1);
         spacePrint2();
         System.out.println("[  유효하지 않은 번호입니다 다시 입력해주세요  ]");
         DelayUtil.delay(2000);
         printLn(3);
         return View.MOVIE_LIST;
      }

      MovieVo selectedMovie = movieList.get(sel - 1); //자바 인덱스는 0번부터 시작하기떄문에 저장값이 0부터 시작함
      int rateCode = selectedMovie.getFk_rate();      //나는 sel로 1부터시작하기때문에 -1 시행 넣지않는다면 null이나 바운더리 예외발생

      if (!ageCheck(id, rateCode)) {                                       //나이검증 메소드
         printLn(1);
         spacePrint2();
         System.out.println("[  "+memName + "님, 나이제한으로 예매가 불가능합니다  ]");
         spacePrint2();
         System.out.println("[  2초 후 영화 리스트로 이동합니다  ]");
         DelayUtil.delay(2000);
         printLn(3);
         return View.MOVIE_LIST;
      }

      sessionStorage.put("movieNo", sel);
      return View.MOVIE_DETAIL;
   }

   // 영화관메인사이트
   private View admin() {
      MemberVo member = (MemberVo) sessionStorage.get("member");     //
      int memNo = member.getMem_no();
      sessionStorage.put("memNo", memNo);
      String memName = member.getMem_name();                         // 로그인후 첫화면 진입시 회원이름 출력시키기위해 멤버name값 갖고오는 로직
      adminPrint(memName);
//      System.out.println("----------환영합니다! " + memName + "님----------");
//      System.out.println();
//      System.out.println("1. 예매화면으로");
//      System.out.println("2. 마이페이지");
//      System.out.println("3. 로그아웃");
      menuPrint();
      int sel = ScanUtil.menu();
      switch (sel) {
         case 1:
            return View.MOVIE_LIST;
         case 2:
            return View.MEMBER_DETAIL;
         case 3:
            spacePrint1();
            System.out.println("[  로그아웃 하였습니다  ]");
            DelayUtil.delay(2000);
            sessionStorage.clear();
            return View.MAIN;
         default:
            return View.ADMIN;
      }
   }

   // 회원가입
   private View signUp() {
      signUpPrint();
//      System.out.println("회원가입 화면입니다");
//      System.out.println("개인 정보를 입력해주세요");
      menuPrint();
      spacePrint1();
      String name = ScanUtil.nextLine("이름 : ");
      spacePrint1();
      String id = ScanUtil.nextLine("ID : ");
      spacePrint1();
      String pw = ScanUtil.nextLine("PW : ");
      spacePrint1();
      String bir = ScanUtil.nextLine("생년월일 8자리 : ");
      if (!isValidDate(bir)) {
         printLn(2);
         spacePrint2();
         System.out.println("[  잘못된 생년월일 형식입니다. ex)19990718  ]");
         DelayUtil.delay(2000);
         printLn(2);
         return View.SIGN_UP;
      }
      spacePrint1();
      String nickname = ScanUtil.nextLine("닉네임 : ");
      // 로그인 id 중복 검증
      // #설계미스#
      // 1. 처음부터 id를 기본키 값으로 설정했으면 null값, 중복값 금지여서
      // 굳이 로직을 구성하지않아도 알아서 db validation에서 걸렸을것(현재는 mem_No가 기본키)
      // 다음부터는 id처럼 중복값이 무조건 금지되는 컬럼은 기본키값을 설정하는것을 고려한다.
      memberService.idInfo();
      List<String> memIdList = (List<String>) sessionStorage.get("idInfo");
      // 리스트로 검증
      if (memIdList.contains(id)) {
         printLn(2);
         spacePrint2();
         System.out.println("[  중복된 id입니다 다시 설정해주세요  ]");
         printLn(2);
         // 다시 회원가입으로 스캔값입력하도록
         return View.SIGN_UP;
      }
      List<Object> param = new ArrayList<>();
      param.add(name);
      param.add(id);
      param.add(pw);
      param.add(bir);
      param.add(nickname);

      memberService.signUp(param);
      signUpPrint1();
      param.clear(); //초기화면으로 복귀시 파라미터 클리어시켜서 나중에 null넣어도 회원가입이 되는것 방지
      return View.MAIN;
   }

   //생년월일 검증
   private boolean isValidDate(String date) {
      if (date == null || date.length() != 8) {
         return false;
      }
      try {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
         sdf.setLenient(false);
         sdf.parse(date);
         return true;
      } catch (ParseException e) {
         return false;
      }
   }

   // 로그인
   private View login() {
      loginPrint();
//      var();
//      System.out.println("로그인 하십시오");
      menuPrint();
      spacePrint2();
      String id = ScanUtil.nextLine("ID : ");
      spacePrint2();
      String pw = ScanUtil.nextLine("PW : ");
      List<Object> param = new ArrayList<>();
      param.add(id);
      sessionStorage.put("id", id); // id값 sessionstorage에 저장
      param.add(pw);
      boolean login = memberService.login(param);
      if (!login) {
         loginIssue();
//         System.out.println("ID 혹은 PW를 잘못 입력 하셨습니다.");
//         System.out.println("1. 재로그인");
//         System.out.println("2. 회원가입");
//         System.out.println("3. 초기 화면으로");
//         System.out.println();
         menuPrint();
         int sel = ScanUtil.menu();
         switch (sel) {
            case 1:
               return View.LOGIN;
            case 2:
               param.clear(); //회원가입창으로 갈때 파라미터 초기화
               return View.SIGN_UP;
            case 3:
               param.clear(); //초기화면으로갈때 로그인시도 파라미터값 삭제
               return View.MAIN;
            default: return View.LOGIN;
         }
      }
      View view = null;
      if (sessionStorage.containsKey("view")) {
         view = (View) sessionStorage.get("view");
         return view;
      }
      return View.ADMIN;
   }

   public View main() {
      List<Object> param = new ArrayList<Object>();
      List<BookingVo> bkCheck = bookingService.bkCheckSelect();
      for (BookingVo bookingVo : bkCheck) {
         param.add(bookingVo.getFk_seat_code());
         seatService.seatStatusUpdate(param);
         param.clear();
      }
      bookingService.bkCheckDelete();
      mainPrint1();
      menuPrint();

      int sel = ScanUtil.menu();
      switch (sel) {
         case 1:
            return View.LOGIN;
         case 2:
            return View.SIGN_UP;
         default:
            return View.MAIN;
      }
   }
}