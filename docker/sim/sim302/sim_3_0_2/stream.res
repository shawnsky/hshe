./sim_c (Build Mar 14 2018, 16:26:32)
Subject: C programs
Option settings:
 -r10 (set minimum run size to N)
 -w80 (set page width to N)
 -O (show command line options at start-up)
 -M (show memory usage info at close-down)
 -- (lexical scan output only)
File pass2.c: showing the token stream
line # = 1, token # = 0:
line # = 2, token # = 0:
line # = 3, token # = 0:
line # = 4, token # = 0:
line # = 5, token # = 0:
line # = 6, token # = 0:
line # = 7, token # = 0:
line # = 8, token # = 0:
line # = 9, token # = 0:
line # = 10, token # = 0:
line # = 11, token # = 0:
line # = 12, token # = 0:
line # = 13, token # = 0:
line # = 14, token # = 0:
line # = 15, token # = 0:
line # = 16, token # = 0:
line # = 17, token # = 0:
 #ifdef -> META(I)
 DB_POS -> IDF
line # = 18, token # = 2:
line # = 19, token # = 2:
 #endif -> META(E)
line # = 20, token # = 3:
line # = 21, token # = 3:
line # = 22, token # = 3:
 static -> CTRL(S)
 sort_pos_list -> IDF
 ( -> (
 struct -> META(s)
 position -> IDF
 * -> *
 * -> *
 ) -> )
line # = 23, token # = 11:
 #define -> META(d)
 SORT_STRUCT -> IDF
 position -> IDF
line # = 24, token # = 14:
 #define -> META(d)
 SORT_NAME -> IDF
 sort_pos_list -> IDF
line # = 25, token # = 17:
 #define -> META(d)
 SORT_BEFORE -> IDF
 ( -> (
 p1 -> IDF
 , -> ,
 p2 -> IDF
 ) -> )
 ( -> (
 ( -> (
 p1 -> IDF
 ) -> )
 - -> -
 > -> >
 ps_tk_cnt -> IDF
 < -> <
 ( -> (
 p2 -> IDF
 ) -> )
 - -> -
 > -> >
 ps_tk_cnt -> IDF
 ) -> )
line # = 26, token # = 39:
 #define -> META(d)
 SORT_NEXT -> IDF
 ps_next -> IDF
line # = 27, token # = 42:
line # = 28, token # = 42:
line # = 29, token # = 42:
line # = 30, token # = 42:
 static -> CTRL(S)
line # = 31, token # = 43:
 match_pos_list_of -> IDF
 ( -> (
 struct -> META(s)
 text -> IDF
 * -> *
 txt -> IDF
 ) -> )
 { -> {
line # = 32, token # = 51:
 struct -> META(s)
 position -> IDF
 * -> *
 pos -> IDF
 = -> =
 txt -> IDF
 - -> -
 > -> >
 tx_pos -> IDF
line # = 33, token # = 60:
line # = 34, token # = 60:
 while -> NORM(w)
 ( -> (
 pos -> IDF
 ) -> )
 { -> {
line # = 35, token # = 65:
line # = 36, token # = 65:
line # = 37, token # = 65:
line # = 38, token # = 65:
 while -> NORM(w)
 ( -> (
 pos -> IDF
 - -> -
 > -> >
 ps_tk_cnt -> IDF
 > -> >
 = -> =
 lex_tk_cnt -> IDF
 ) -> )
 { -> {
line # = 39, token # = 76:
line # = 40, token # = 76:
line # = 41, token # = 76:
line # = 42, token # = 76:
line # = 43, token # = 76:
 int -> NORM(I)
 ok -> IDF
 = -> =
 0 -> IDF
line # = 44, token # = 80:
 while -> NORM(w)
 ( -> (
 Next_Text_Token_Obtained -> IDF
 ( -> (
 ) -> )
 ) -> )
 { -> {
line # = 45, token # = 87:
 if -> NORM(i)
 ( -> (
 Token_EQ -> IDF
 ( -> (
 lex_token -> IDF
 , -> ,
 End_Of_Line -> IDF
 ) -> )
 ) -> )
 { -> {
line # = 46, token # = 97:
 ok -> IDF
 = -> =
 1 -> IDF
line # = 47, token # = 100:
 break -> NORM(b)
line # = 48, token # = 101:
 } -> }
line # = 49, token # = 102:
 } -> }
line # = 50, token # = 103:
 if -> NORM(i)
 ( -> (
 ! -> !
 ok -> IDF
 ) -> )
 { -> {
line # = 51, token # = 109:
line # = 52, token # = 109:
 if -> NORM(i)
 ( -> (
 ! -> !
 txt -> IDF
 - -> -
 > -> >
 tx_EOL_terminated -> IDF
 ) -> )
 { -> {
line # = 53, token # = 118:
line # = 54, token # = 118:
 } -> }
 else -> NORM(e)
 { -> {
line # = 55, token # = 121:
 fprintf -> IDF
 ( -> (
 stderr -> IDF
 , -> ,
line # = 56, token # = 125:
 ">>>> File %s modified <<<<\n" -> STR
 , -> ,
line # = 57, token # = 127:
 txt -> IDF
 - -> -
 > -> >
 tx_fname -> IDF
line # = 58, token # = 131:
 ) -> )
line # = 59, token # = 132:
 } -> }
line # = 60, token # = 133:
 break -> NORM(b)
line # = 61, token # = 134:
 } -> }
line # = 62, token # = 135:
 #ifdef -> META(I)
 DB_POS -> IDF
line # = 63, token # = 137:
 db_print_lex -> IDF
 ( -> (
 txt -> IDF
 - -> -
 > -> >
 tx_fname -> IDF
 ) -> )
line # = 64, token # = 144:
 #endif -> META(E)
line # = 65, token # = 145:
 } -> }
line # = 66, token # = 146:
line # = 67, token # = 146:
line # = 68, token # = 146:
 pos -> IDF
 - -> -
 > -> >
 ps_nl_cnt -> IDF
 = -> =
 lex_nl_cnt -> IDF
 - -> -
 1 -> IDF
line # = 69, token # = 154:
line # = 70, token # = 154:
line # = 71, token # = 154:
 pos -> IDF
 = -> =
 pos -> IDF
 - -> -
 > -> >
 ps_next -> IDF
line # = 72, token # = 160:
 } -> }
line # = 73, token # = 161:
 } -> }
line # = 74, token # = 162:
line # = 75, token # = 162:
 static -> CTRL(S)
line # = 76, token # = 163:
 pass2_txt -> IDF
 ( -> (
 struct -> META(s)
 text -> IDF
 * -> *
 txt -> IDF
 ) -> )
 { -> {
line # = 77, token # = 171:
 if -> NORM(i)
 ( -> (
 ! -> !
 txt -> IDF
 - -> -
 > -> >
 tx_pos -> IDF
 ) -> )
line # = 78, token # = 179:
 return -> NORM(r)
line # = 79, token # = 180:
line # = 80, token # = 180:
line # = 81, token # = 180:
 if -> NORM(i)
 ( -> (
 ! -> !
 Open_Text -> IDF
 ( -> (
 txt -> IDF
 ) -> )
 ) -> )
 { -> {
line # = 82, token # = 189:
 fprintf -> IDF
 ( -> (
 stderr -> IDF
 , -> ,
 ">>>> File %s disappeared <<<<\n" -> STR
 , -> ,
line # = 83, token # = 195:
 txt -> IDF
 - -> -
 > -> >
 tx_fname -> IDF
line # = 84, token # = 199:
 ) -> )
line # = 85, token # = 200:
 return -> NORM(r)
line # = 86, token # = 201:
 } -> }
line # = 87, token # = 202:
line # = 88, token # = 202:
line # = 89, token # = 202:
line # = 90, token # = 202:
line # = 91, token # = 202:
line # = 92, token # = 202:
 #ifdef -> META(I)
 DB_POS -> IDF
line # = 93, token # = 204:
 db_print_pos_list -> IDF
 ( -> (
 "before sorting" -> STR
 , -> ,
 txt -> IDF
 ) -> )
line # = 94, token # = 210:
 #endif -> META(E)
line # = 95, token # = 211:
line # = 96, token # = 211:
 sort_pos_list -> IDF
 ( -> (
 & -> &
 txt -> IDF
 - -> -
 > -> >
 tx_pos -> IDF
 ) -> )
line # = 97, token # = 219:
line # = 98, token # = 219:
 #ifdef -> META(I)
 DB_POS -> IDF
line # = 99, token # = 221:
 db_print_pos_list -> IDF
 ( -> (
 "after sorting" -> STR
 , -> ,
 txt -> IDF
 ) -> )
line # = 100, token # = 227:
 #endif -> META(E)
line # = 101, token # = 228:
line # = 102, token # = 228:
 #ifdef -> META(I)
 DB_POS -> IDF
line # = 103, token # = 230:
 fprintf -> IDF
 ( -> (
 Debug_File -> IDF
 , -> ,
 "\n**** DB_PRINT_SCAN of %s ****\n" -> STR
 , -> ,
 txt -> IDF
 - -> -
 > -> >
 tx_fname -> IDF
 ) -> )
line # = 104, token # = 241:
 #endif -> META(E)
line # = 105, token # = 242:
line # = 106, token # = 242:
 match_pos_list_of -> IDF
 ( -> (
 txt -> IDF
 ) -> )
line # = 107, token # = 246:
line # = 108, token # = 246:
 #ifdef -> META(I)
 DB_POS -> IDF
line # = 109, token # = 248:
 db_print_pos_list -> IDF
 ( -> (
 "after scanning" -> STR
 , -> ,
 txt -> IDF
 ) -> )
line # = 110, token # = 254:
 #endif -> META(E)
line # = 111, token # = 255:
line # = 112, token # = 255:
 Close_Text -> IDF
 ( -> (
 ) -> )
line # = 113, token # = 258:
 } -> }
line # = 114, token # = 259:
line # = 115, token # = 259:
line # = 116, token # = 259:
 Retrieve_Runs -> IDF
 ( -> (
 ) -> )
 { -> {
line # = 117, token # = 263:
 int -> NORM(I)
 n -> IDF
line # = 118, token # = 265:
line # = 119, token # = 265:
 for -> NORM(F)
 ( -> (
 n -> IDF
 = -> =
 0 -> IDF
 n -> IDF
 < -> <
 Number_of_Texts -> IDF
 n -> IDF
 + -> +
 + -> +
 ) -> )
 { -> {
line # = 120, token # = 278:
 pass2_txt -> IDF
 ( -> (
 & -> &
 Text -> IDF
 [ -> [
 n -> IDF
 ] -> ]
 ) -> )
line # = 121, token # = 286:
 } -> }
line # = 122, token # = 287:
 } -> }
line # = 123, token # = 288:

File pass1.c: showing the token stream
line # = 1, token # = 0:
line # = 2, token # = 0:
line # = 3, token # = 0:
line # = 4, token # = 0:
line # = 5, token # = 0:
line # = 6, token # = 0:
line # = 7, token # = 0:
line # = 8, token # = 0:
line # = 9, token # = 0:
line # = 10, token # = 0:
line # = 11, token # = 0:
line # = 12, token # = 0:
line # = 13, token # = 0:
line # = 14, token # = 0:
line # = 15, token # = 0:
line # = 16, token # = 0:
line # = 17, token # = 0:
line # = 18, token # = 0:
 #ifdef -> META(I)
 DB_TEXT -> IDF
line # = 19, token # = 2:
line # = 20, token # = 2:
 #endif -> META(E)
line # = 21, token # = 3:
line # = 22, token # = 3:
 static -> CTRL(S)
line # = 23, token # = 4:
 do_separator -> IDF
 ( -> (
 const -> IDF
 struct -> META(s)
 text -> IDF
 * -> *
 txt -> IDF
 , -> ,
 const -> IDF
 char -> NORM(C)
 * -> *
 fname -> IDF
 ) -> )
 { -> {
line # = 24, token # = 18:
 if -> NORM(i)
 ( -> (
 ! -> !
 is_set_option -> IDF
 ( -> (
 'T' -> '
 ) -> )
 ) -> )
 { -> {
line # = 25, token # = 27:
 fprintf -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 "File %s: new/old separator\n" -> STR
 , -> ,
 fname -> IDF
 ) -> )
line # = 26, token # = 35:
 } -> }
line # = 27, token # = 36:
 if -> NORM(i)
 ( -> (
 Number_of_New_Texts -> IDF
 = -> =
 = -> =
 Number_of_Texts -> IDF
 ) -> )
 { -> {
line # = 28, token # = 44:
line # = 29, token # = 44:
 Number_of_New_Texts -> IDF
 = -> =
 txt -> IDF
 - -> -
 & -> &
 Text -> IDF
 [ -> [
 0 -> IDF
 ] -> ]
line # = 30, token # = 53:
 } -> }
 else -> NORM(e)
 { -> {
line # = 31, token # = 56:
 fatal -> IDF
 ( -> (
 "more than one new/old separator" -> STR
 ) -> )
line # = 32, token # = 60:
 } -> }
line # = 33, token # = 61:
 } -> }
line # = 34, token # = 62:
line # = 35, token # = 62:
 static -> CTRL(S)
 int -> NORM(I)
line # = 36, token # = 64:
 read_text -> IDF
 ( -> (
 const -> IDF
 char -> NORM(C)
 * -> *
 fname -> IDF
 , -> ,
 struct -> META(s)
 text -> IDF
 * -> *
 txt -> IDF
 ) -> )
 { -> {
line # = 37, token # = 77:
 int -> NORM(I)
 file_opened -> IDF
 = -> =
 0 -> IDF
line # = 38, token # = 81:
 if -> NORM(i)
 ( -> (
 Open_Text -> IDF
 ( -> (
 txt -> IDF
 ) -> )
 ) -> )
 { -> {
line # = 39, token # = 89:
 file_opened -> IDF
 = -> =
 1 -> IDF
line # = 40, token # = 92:
 } -> }
 else -> NORM(e)
 { -> {
line # = 41, token # = 95:
line # = 42, token # = 95:
 fprintf -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 "File %s: >>>> cannot open <<<<\n" -> STR
 , -> ,
 fname -> IDF
 ) -> )
line # = 43, token # = 103:
line # = 44, token # = 103:
line # = 45, token # = 103:
line # = 46, token # = 103:
 } -> }
line # = 47, token # = 104:
line # = 48, token # = 104:
 while -> NORM(w)
 ( -> (
 Next_Text_Token_Obtained -> IDF
 ( -> (
 ) -> )
 ) -> )
 { -> {
line # = 49, token # = 111:
 if -> NORM(i)
 ( -> (
 ! -> !
 Token_EQ -> IDF
 ( -> (
 lex_token -> IDF
 , -> ,
 End_Of_Line -> IDF
 ) -> )
 ) -> )
 { -> {
line # = 50, token # = 122:
 Store_Token -> IDF
 ( -> (
 lex_token -> IDF
 ) -> )
line # = 51, token # = 126:
 } -> }
line # = 52, token # = 127:
 } -> }
line # = 53, token # = 128:
 Close_Text -> IDF
 ( -> (
 ) -> )
line # = 54, token # = 131:
 txt -> IDF
 - -> -
 > -> >
 tx_limit -> IDF
 = -> =
 Token_Array_Length -> IDF
 ( -> (
 ) -> )
line # = 55, token # = 139:
 txt -> IDF
 - -> -
 > -> >
 tx_EOL_terminated -> IDF
 = -> =
line # = 56, token # = 144:
 Token_EQ -> IDF
 ( -> (
 lex_token -> IDF
 , -> ,
 End_Of_Line -> IDF
 ) -> )
line # = 57, token # = 150:
line # = 58, token # = 150:
 #ifdef -> META(I)
 DB_TEXT -> IDF
line # = 59, token # = 152:
 db_print_text -> IDF
 ( -> (
 txt -> IDF
 ) -> )
line # = 60, token # = 156:
 #endif -> META(E)
line # = 61, token # = 157:
line # = 62, token # = 157:
 return -> NORM(r)
 file_opened -> IDF
line # = 63, token # = 159:
 } -> }
line # = 64, token # = 160:
line # = 65, token # = 160:
 static -> CTRL(S)
line # = 66, token # = 161:
 fprint_count -> IDF
 ( -> (
 FILE -> IDF
 * -> *
 f -> IDF
 , -> ,
 size_t -> IDF
 cnt -> IDF
 , -> ,
 const -> IDF
 char -> NORM(C)
 * -> *
 unit -> IDF
 ) -> )
 { -> {
line # = 67, token # = 176:
line # = 68, token # = 176:
line # = 69, token # = 176:
line # = 70, token # = 176:
 fprintf -> IDF
 ( -> (
 f -> IDF
 , -> ,
 "%s %s%s" -> STR
 , -> ,
 size_t2string -> IDF
 ( -> (
 cnt -> IDF
 ) -> )
 , -> ,
 unit -> IDF
 , -> ,
 ( -> (
 cnt -> IDF
 = -> =
 = -> =
 1 -> IDF
 ? -> ?
 "" -> STR
 : -> :
 "s" -> STR
 ) -> )
 ) -> )
line # = 71, token # = 200:
 } -> }
line # = 72, token # = 201:
line # = 73, token # = 201:
 static -> CTRL(S)
line # = 74, token # = 202:
 report_file -> IDF
 ( -> (
 const -> IDF
 char -> NORM(C)
 * -> *
 fname -> IDF
 , -> ,
 struct -> META(s)
 text -> IDF
 * -> *
 txt -> IDF
 ) -> )
 { -> {
line # = 75, token # = 215:
 fprintf -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 "File %s: " -> STR
 , -> ,
 fname -> IDF
 ) -> )
line # = 76, token # = 223:
 fprint_count -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 txt -> IDF
 - -> -
 > -> >
 tx_limit -> IDF
 - -> -
 txt -> IDF
 - -> -
 > -> >
 tx_start -> IDF
 , -> ,
 Token_Name -> IDF
 ) -> )
line # = 77, token # = 239:
 fprintf -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 ", " -> STR
 ) -> )
line # = 78, token # = 245:
 fprint_count -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
line # = 79, token # = 249:
 lex_nl_cnt -> IDF
 - -> -
 1 -> IDF
 + -> +
 ( -> (
 ! -> !
 txt -> IDF
 - -> -
 > -> >
 tx_EOL_terminated -> IDF
 ? -> ?
 1 -> IDF
 : -> :
 0 -> IDF
 ) -> )
 , -> ,
 "line" -> STR
line # = 80, token # = 266:
 ) -> )
line # = 81, token # = 267:
 if -> NORM(i)
 ( -> (
 ! -> !
 txt -> IDF
 - -> -
 > -> >
 tx_EOL_terminated -> IDF
 ) -> )
 { -> {
line # = 82, token # = 276:
 fprintf -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 " (not NL-terminated)" -> STR
 ) -> )
line # = 83, token # = 282:
 } -> }
line # = 84, token # = 283:
 if -> NORM(i)
 ( -> (
 lex_non_ASCII_cnt -> IDF
 ) -> )
 { -> {
line # = 85, token # = 288:
 fprintf -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 ", " -> STR
 ) -> )
line # = 86, token # = 294:
 fprint_count -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
line # = 87, token # = 298:
 lex_non_ASCII_cnt -> IDF
 , -> ,
 "non-ASCII character" -> STR
line # = 88, token # = 301:
 ) -> )
line # = 89, token # = 302:
 } -> }
line # = 90, token # = 303:
 fprintf -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 "\n" -> STR
 ) -> )
line # = 91, token # = 309:
 } -> }
line # = 92, token # = 310:
line # = 93, token # = 310:
 static -> CTRL(S)
line # = 94, token # = 311:
 read_file -> IDF
 ( -> (
 const -> IDF
 char -> NORM(C)
 * -> *
 fname -> IDF
 , -> ,
 struct -> META(s)
 text -> IDF
 * -> *
 txt -> IDF
 ) -> )
 { -> {
line # = 95, token # = 324:
 txt -> IDF
 - -> -
 > -> >
 tx_fname -> IDF
 = -> =
 fname -> IDF
line # = 96, token # = 330:
 txt -> IDF
 - -> -
 > -> >
 tx_pos -> IDF
 = -> =
 0 -> IDF
line # = 97, token # = 336:
 txt -> IDF
 - -> -
 > -> >
 tx_start -> IDF
 = -> =
 Token_Array_Length -> IDF
 ( -> (
 ) -> )
line # = 98, token # = 344:
 txt -> IDF
 - -> -
 > -> >
 tx_limit -> IDF
 = -> =
 Token_Array_Length -> IDF
 ( -> (
 ) -> )
line # = 99, token # = 352:
line # = 100, token # = 352:
 if -> NORM(i)
 ( -> (
 is_new_old_separator -> IDF
 ( -> (
 fname -> IDF
 ) -> )
 ) -> )
 { -> {
line # = 101, token # = 360:
 do_separator -> IDF
 ( -> (
 txt -> IDF
 , -> ,
 fname -> IDF
 ) -> )
line # = 102, token # = 366:
 } -> }
line # = 103, token # = 367:
 else -> NORM(e)
 { -> {
line # = 104, token # = 369:
 int -> NORM(I)
 ok -> IDF
 = -> =
 read_text -> IDF
 ( -> (
 fname -> IDF
 , -> ,
 txt -> IDF
 ) -> )
line # = 105, token # = 378:
 if -> NORM(i)
 ( -> (
 ok -> IDF
 & -> &
 & -> &
 ! -> !
 is_set_option -> IDF
 ( -> (
 'T' -> '
 ) -> )
 ) -> )
 { -> {
line # = 106, token # = 390:
 report_file -> IDF
 ( -> (
 fname -> IDF
 , -> ,
 txt -> IDF
 ) -> )
line # = 107, token # = 396:
 } -> }
line # = 108, token # = 397:
 } -> }
line # = 109, token # = 398:
line # = 110, token # = 398:
 fflush -> IDF
 ( -> (
 Output_File -> IDF
 ) -> )
line # = 111, token # = 402:
 } -> }
line # = 112, token # = 403:
line # = 113, token # = 403:
line # = 114, token # = 403:
 Read_Input_Files -> IDF
 ( -> (
 int -> NORM(I)
 argc -> IDF
 , -> ,
 const -> IDF
 char -> NORM(C)
 * -> *
 argv -> IDF
 [ -> [
 ] -> ]
 ) -> )
 { -> {
line # = 115, token # = 416:
 int -> NORM(I)
 n -> IDF
line # = 116, token # = 418:
line # = 117, token # = 418:
 Init_Text -> IDF
 ( -> (
 argc -> IDF
 ) -> )
line # = 118, token # = 422:
 Init_Token_Array -> IDF
 ( -> (
 ) -> )
line # = 119, token # = 425:
line # = 120, token # = 425:
line # = 121, token # = 425:
 Number_of_New_Texts -> IDF
 = -> =
 Number_of_Texts -> IDF
line # = 122, token # = 428:
line # = 123, token # = 428:
line # = 124, token # = 428:
 for -> NORM(F)
 ( -> (
 n -> IDF
 = -> =
 0 -> IDF
 n -> IDF
 < -> <
 Number_of_Texts -> IDF
 n -> IDF
 + -> +
 + -> +
 ) -> )
 { -> {
line # = 125, token # = 441:
line # = 126, token # = 441:
 read_file -> IDF
 ( -> (
 argv -> IDF
 [ -> [
 n -> IDF
 ] -> ]
 , -> ,
 & -> &
 Text -> IDF
 [ -> [
 n -> IDF
 ] -> ]
 ) -> )
line # = 127, token # = 454:
 } -> }
line # = 128, token # = 455:
line # = 129, token # = 455:
line # = 130, token # = 455:
 int -> NORM(I)
 sep_present -> IDF
 = -> =
 ( -> (
 Number_of_Texts -> IDF
 ! -> !
 = -> =
 Number_of_New_Texts -> IDF
 ) -> )
line # = 131, token # = 464:
 fprintf -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 "Total input: " -> STR
 ) -> )
line # = 132, token # = 470:
 fprint_count -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
line # = 133, token # = 474:
 ( -> (
 ! -> !
 sep_present -> IDF
 ? -> ?
 Number_of_Texts -> IDF
 : -> :
 Number_of_Texts -> IDF
 - -> -
 1 -> IDF
 ) -> )
 , -> ,
line # = 134, token # = 485:
 "file" -> STR
line # = 135, token # = 486:
 ) -> )
line # = 136, token # = 487:
 fprintf -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 " (%d new, %d old), " -> STR
 , -> ,
line # = 137, token # = 493:
 Number_of_New_Texts -> IDF
 , -> ,
line # = 138, token # = 495:
 ( -> (
 ! -> !
 sep_present -> IDF
 ? -> ?
 0 -> IDF
 : -> :
 Number_of_Texts -> IDF
 - -> -
 Number_of_New_Texts -> IDF
 - -> -
 1 -> IDF
 ) -> )
line # = 139, token # = 507:
 ) -> )
line # = 140, token # = 508:
 fprint_count -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 Token_Array_Length -> IDF
 ( -> (
 ) -> )
 - -> -
 1 -> IDF
 , -> ,
 Token_Name -> IDF
 ) -> )
line # = 141, token # = 520:
 fprintf -> IDF
 ( -> (
 Output_File -> IDF
 , -> ,
 "\n\n" -> STR
 ) -> )
line # = 142, token # = 526:
 fflush -> IDF
 ( -> (
 Output_File -> IDF
 ) -> )
line # = 143, token # = 530:
 } -> }
line # = 144, token # = 531:

