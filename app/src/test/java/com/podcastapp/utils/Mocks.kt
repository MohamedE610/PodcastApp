package com.podcastapp.utils

import com.podcastapp.core.extension.getObjFromJson
import com.podcastapp.features.playlist.data.PlayListResponse

fun getMockedPlaylistResponse(): PlayListResponse {
    return playlistJson.getObjFromJson()
}

private const val playlistJson = "{\n" +
        "    \"data\": {\n" +
        "        \"playlist\": {\n" +
        "            \"id\": \"01GVD0TTY5RRMHH6YMCW7N1H70\",\n" +
        "            \"type\": 2,\n" +
        "            \"name\": \"أفضل حلقات حوارية في شهر مايو\",\n" +
        "            \"description\": \"أفضل الحلقات التي أُنتجت في شهر مارس، مقابلات مثرية وضيوف مميزين\",\n" +
        "            \"image\": \"https://s3.amazonaws.com/aswaat.com/img/app-assets/playlists-0.png\",\n" +
        "            \"access\": \"public\",\n" +
        "            \"status\": \"published\",\n" +
        "            \"episodeCount\": 6,\n" +
        "            \"episodeTotalDuration\": 40816,\n" +
        "            \"createdAt\": \"2023-03-13T08:19:18.086Z\",\n" +
        "            \"updatedAt\": \"2023-03-13T08:19:18.086Z\",\n" +
        "            \"isDeleted\": false,\n" +
        "            \"followingCount\": 0,\n" +
        "            \"userId\": \"e0e4fc2f-e6c8-415c-a025-79a0c824e39c\",\n" +
        "            \"isSubscribed\": false\n" +
        "        },\n" +
        "        \"episodes\": [\n" +
        "            {\n" +
        "                \"id\": \"aHR0cHM6Ly9sZXhmcmlkbWFuLmNvbS8/cD01NDMy\",\n" +
        "                \"itunesId\": \"aHR0cHM6Ly9sZXhmcmlkbWFuLmNvbS8/cD01NDMy\",\n" +
        "                \"type\": 0,\n" +
        "                \"name\": \"#365 – Sam Harris: Trump, Pandemic, Twitter, Elon, Bret, IDW, Kanye, AI &#038; UFOs\",\n" +
        "                \"description\": \"Sam Harris is an author, podcaster, and philosopher. Please support this podcast by checking out our sponsors:\\n- Notion: https://notion.com\\n- Indeed: https://indeed.com/lex to get \$75 credit\\n- MasterClass: https://masterclass.com/lex to get 15% off\\n\\nEPISODE LINKS:\\nSam&#039;s Website: https://samharris.org\\nMaking Sense Podcast: https://www.samharris.org/podcasts/making-sense-episodes\\nWaking Up App: https://www.wakingup.com\\nSam&#039;s YouTube: https://youtube.com/@samharrisorg\\nSam&#039;s Instagram: https://instagram.com/samharrisorg\\n\\nPODCAST INFO:\\nPodcast website: https://lexfridman.com/podcast\\nApple Podcasts: https://apple.co/2lwqZIr\\nSpotify: https://spoti.fi/2nEwCF8\\nRSS: https://lexfridman.com/feed/podcast/\\nYouTube Full Episodes: https://youtube.com/lexfridman\\nYouTube Clips: https://youtube.com/lexclips\\n\\nSUPPORT & CONNECT:\\n- Check out the sponsors above, it&#039;s the best way to support this podcast\\n- Support on Patreon: https://www.patreon.com/lexfridman\\n- Twitter: https://twitter.com/lexfridman\\n- Instagram: https://www.instagram.com/lexfridman\\n- LinkedIn: https://www.linkedin.com/in/lexfridman\\n- Facebook: https://www.facebook.com/lexfridman\\n- Medium: https://medium.com/@lexfridman\\n\\nOUTLINE:\\nHere&#039;s the timestamps for the episode. On some podcast players you should be able to click the timestamp to jump to that time.\\n(00:00) - Introduction\\n(09:25) - Empathy and reason\\n(17:17) - Donald Trump\\n(1:00:11) - Military industrial complex\\n(1:04:45) - Twitter\\n(1:28:52) - COVID\\n(2:12:35) - Kanye West\\n(2:29:11) - Platforming\\n(2:47:07) - Joe Rogan\\n(3:03:59) - Bret Weinstein\\n(3:17:38) - Elon Musk\\n(3:29:45) - Artificial Intelligence\\n(3:45:48) - UFOs\\n(3:59:03) - Free will\\n(4:26:17) - Hope for the future\",\n" +
        "                \"image\": \"https://lexfridman.com/wordpress/wp-content/uploads/powerpress/artwork_3000-230.png\",\n" +
        "                \"imageBigger\": \"https://lexfridman.com/wordpress/wp-content/uploads/powerpress/artwork_3000-230.png\",\n" +
        "                \"audioLink\": \"https://media.blubrry.com/takeituneasy/content.blubrry.com/takeituneasy/lex_ai_sam_harris_2.mp3\",\n" +
        "                \"duration\": 16420,\n" +
        "                \"durationInSeconds\": 16420,\n" +
        "                \"views\": 0,\n" +
        "                \"podcastItunesId\": \"1434243584\",\n" +
        "                \"podcastName\": \"Lex Fridman Podcast\",\n" +
        "                \"releaseDate\": \"2023-03-14T17:19:34.000Z\",\n" +
        "                \"createdAt\": \"2023-05-05T05:58:19.560Z\",\n" +
        "                \"updatedAt\": \"2023-05-05T05:58:19.560Z\",\n" +
        "                \"isDeleted\": false,\n" +
        "                \"chapters\": [],\n" +
        "                \"isEditorPick\": false,\n" +
        "                \"sentNotification\": false,\n" +
        "                \"position\": 0\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"aHR0cHM6Ly9sZXhmcmlkbWFuLmNvbS8/cD01NDM2\",\n" +
        "                \"itunesId\": \"aHR0cHM6Ly9sZXhmcmlkbWFuLmNvbS8/cD01NDM2\",\n" +
        "                \"type\": 0,\n" +
        "                \"name\": \"#366 – Shannon Curry: Johnny Depp &#038; Amber Heard Trial, Marriage, Dating &#038; Love\",\n" +
        "                \"description\": \"Dr. Shannon Curry is a clinical and forensic psychologist who conducts research, therapy, and clinical evaluation pertaining to trauma, violence, and relationships. She testified in the Johnny Depp and Amber Heard trial. Please support this podcast by checking out our sponsors:\\n- Factor: https://factormeals.com/lex50 and use code lex50 to get 50% off your first box\\n- BetterHelp: https://betterhelp.com/lex to get 10% off\\n- House of Macadamias: https://houseofmacadamias.com/lex and use code LEX to get 20% off your first order\\n\\nEPISODE LINKS:\\nShannon&#039;s Instagram: https://instagram.com/currypsychgroup\\nCurry Psychology Group: https://currypsychology.com/\\n\\nPODCAST INFO:\\nPodcast website: https://lexfridman.com/podcast\\nApple Podcasts: https://apple.co/2lwqZIr\\nSpotify: https://spoti.fi/2nEwCF8\\nRSS: https://lexfridman.com/feed/podcast/\\nYouTube Full Episodes: https://youtube.com/lexfridman\\nYouTube Clips: https://youtube.com/lexclips\\n\\nSUPPORT & CONNECT:\\n- Check out the sponsors above, it&#039;s the best way to support this podcast\\n- Support on Patreon: https://www.patreon.com/lexfridman\\n- Twitter: https://twitter.com/lexfridman\\n- Instagram: https://www.instagram.com/lexfridman\\n- LinkedIn: https://www.linkedin.com/in/lexfridman\\n- Facebook: https://www.facebook.com/lexfridman\\n- Medium: https://medium.com/@lexfridman\\n\\nOUTLINE:\\nHere&#039;s the timestamps for the episode. On some podcast players you should be able to click the timestamp to jump to that time.\\n(00:00) - Introduction\\n(05:41) - Starting a relationship\\n(09:40) - Couples therapy\\n(16:57) - Why relationships fail\\n(24:15) - Drama in relationships\\n(29:42) - Success in relationships\\n(36:06) - Dating\\n(44:42) - Sex\\n(46:36) - Cheating\\n(55:37) - Polyamory\\n(57:28) - Johnny Depp and Amber Heard trial\\n(1:26:06) - Forensic psychology\\n(1:36:16) - PTSD\\n(1:45:51) - Advice for young people\\n(1:48:42) - Love\",\n" +
        "                \"image\": \"https://lexfridman.com/wordpress/wp-content/uploads/powerpress/artwork_3000-230.png\",\n" +
        "                \"imageBigger\": \"https://lexfridman.com/wordpress/wp-content/uploads/powerpress/artwork_3000-230.png\",\n" +
        "                \"audioLink\": \"https://media.blubrry.com/takeituneasy/content.blubrry.com/takeituneasy/lex_ai_shannon_curry.mp3\",\n" +
        "                \"duration\": 6654,\n" +
        "                \"durationInSeconds\": 6654,\n" +
        "                \"views\": 0,\n" +
        "                \"podcastItunesId\": \"1434243584\",\n" +
        "                \"podcastName\": \"Lex Fridman Podcast\",\n" +
        "                \"releaseDate\": \"2023-03-21T23:02:22.000Z\",\n" +
        "                \"createdAt\": \"2023-05-09T10:19:36.283Z\",\n" +
        "                \"updatedAt\": \"2023-05-09T10:19:36.283Z\",\n" +
        "                \"isDeleted\": false,\n" +
        "                \"chapters\": [],\n" +
        "                \"isEditorPick\": false,\n" +
        "                \"sentNotification\": false,\n" +
        "                \"position\": 0\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"N2NmMmQzODktM2QxMS00ZTI5LTk0YmItZWY1YTY2Y2U0MzFh\",\n" +
        "                \"itunesId\": \"N2NmMmQzODktM2QxMS00ZTI5LTk0YmItZWY1YTY2Y2U0MzFh\",\n" +
        "                \"type\": 0,\n" +
        "                \"name\": \"مين المسؤل عن مصاريف البيت ؟\",\n" +
        "                \"description\": \"<p>مين المسؤل عن النواحى الماديه فى البيت و هل تشاركك زوجتك فى مصاريف البيت ؟</p>\\n\",\n" +
        "                \"image\": \"https://d3t3ozftmdmh3i.cloudfront.net/production/podcast_uploaded/18772276/18772276-1640979393495-254fbfc1685a7.jpg\",\n" +
        "                \"imageBigger\": \"https://d3t3ozftmdmh3i.cloudfront.net/production/podcast_uploaded/18772276/18772276-1640979393495-254fbfc1685a7.jpg\",\n" +
        "                \"audioLink\": \"https://anchor.fm/s/707cced0/podcast/play/70392212/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2023-4-15%2F3a572d28-d91a-6aea-44d6-791001c9a371.m4a\",\n" +
        "                \"duration\": 109,\n" +
        "                \"durationInSeconds\": 109,\n" +
        "                \"views\": 0,\n" +
        "                \"podcastItunesId\": \"1592887942\",\n" +
        "                \"podcastName\": \"فنجان قهوه مع جيهان \",\n" +
        "                \"releaseDate\": \"2023-05-15T06:16:50.000Z\",\n" +
        "                \"createdAt\": \"2024-01-08T04:39:44.990Z\",\n" +
        "                \"updatedAt\": \"2024-01-08T04:39:44.990Z\",\n" +
        "                \"isDeleted\": false,\n" +
        "                \"chapters\": [],\n" +
        "                \"isEditorPick\": false,\n" +
        "                \"sentNotification\": false,\n" +
        "                \"position\": 0\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"ODRmNDA5N2UtMzliOC00MDE4LTkyMTUtYWY0YjAxM2Y1MmQz\",\n" +
        "                \"itunesId\": \"ODRmNDA5N2UtMzliOC00MDE4LTkyMTUtYWY0YjAxM2Y1MmQz\",\n" +
        "                \"type\": 0,\n" +
        "                \"name\": \"كيف تنجح العلاقات مع ياسر الحزيمي\",\n" +
        "                \"description\": \"نشرة بريدية من عبدالرحمن أبومالح وفريق فنجان، لجمهور البودكاست المقربين.\\n\\nتُعد الصحة النفسية من المواضيع المهمة جدًّا لي وللكثيرين، وأجد أنّ أحد أهم مقوّمات الصحة النفسية العلاقاتُ الإنسانيةُ. \\n\\nوللحديث أكثر عنها، استضفت ياسر الحزيمي، مدرّب معتمد ذو خبرة في تقديم الدورات والمحاضرات في مجال «تطوير العلاقات ومهارات الاتصال».\\n\\nيقول الحزيمي: «العلاقات لازم تدخلها معك سيف وغمد ودرع.» مشيرًا إلى أن الإنسان ينبغي أن يحقّق التوازن في علاقاته، دون زيادة في لطف يكسره أو عنف يبعد الآخرين عنه.\\n\\nثمّ حدّثني عن أهم أركان العلاقات الإنسانية، فما تعامُلنا مع الآخرين سوى انعكاس لعلاقتنا مع الله، وكذلك علاقتنا بأنفسنا. كما ذكر لي الشكل الصحيح للعلاقات، فينبغي للشخص ألا يُظهِر نفسه بهيئة بعيدة عن حقيقته، ويؤكد أن ذلك من الأسباب التي تؤدي إلى الحزن والاكتئاب.\\n\\nكما سألته عن حبّ الذات، والفرق بينه وبين الغرور. ثمّ انتقلت في حديثي معه إلى الفردانية وانحسار العائلة، والعلاقات الإنسانية في ظل وسائل التواصل الاجتماعي. واختتمنا الحلقة بالحديث عن العلاقة بين الجنسين في الزواج أو بيئات العمل في ظل تغيُّر المجتمع.\\n\\nالحلقة 277 من بودكاست فنجان مع ياسر الحزيمي. بوسعك الاستماع إلى الحلقة من خلال منصات البودكاست على الهاتف المحمول. نرشّح الاستماع إلى البودكاست عبر تطبيق (Apple Podcasts) على الآيفون، وتطبيق (Google Podcasts) على الأندرويد.\\n\\nويهمنا معرفة رأيك عن الحلقات، وتقييمك للبودكاست على (Apple Podcast). كما بوسعك اقتراح ضيف لبودكاست فنجان بمراسلتنا على: <a href=\\\"mailto:fnjan@thmanyah.com\\\">fnjan@thmanyah.com</a> \\n\\nليصلك جديد ثمانية، اشترك في نشراتنا البريدية من هنا.\\n\\nتطبيق سوم لبيع وشراء الأجهزة الإلكترونية المستعملة.\\n\\nسلوشنز المزوّد الأول لحلول تقنية المعلومات في المملكة.\\n\\nسواء كنت من عشّاق القهوة بتحضير صنّاعها المحترفين أم تفضّل تحضيرها في المنزل. نشْرُف بإثرائك في عالم القهوة المختصة، ابدأ بخطوة، وشاركنا تجربتك عبر منصاتنا التفاعلية.\\n\\nللتسجيل في جولة مسك في عرعر.\\n\\nحياتك الصحية أسهل مع تطبيق كالو (كود الخصم: ثمانية) صالح لمدة سنة ويشمل كل الاشتراكات ما عدا غداء العمل.\\n\\nالروابط:\\n\\n\\nسلسلة أفلام جينوم.\\nالصحة النفسية في بيئة العمل — حلقة هاجر القايدي\\nكيف أصبحنا جيلًا هشًّا نفسيًّا — حلقة عبدالله السبيعي\\nأزمة الوجود البشري في القرن الحادي والعشرين — حلقة همّام يحيى\\nSee <a href=\\\"https://omnystudio.com/listener\\\">omnystudio.com/listener</a> for privacy information.\",\n" +
        "                \"image\": \"https://is1-ssl.mzstatic.com/image/thumb/Podcasts122/v4/ed/bf/85/edbf85e5-931c-5da1-ae4c-78a23865efad/mza_9501009785385070744.jpg/600x600bb.jpg\",\n" +
        "                \"imageBigger\": \"https://is1-ssl.mzstatic.com/image/thumb/Podcasts122/v4/ed/bf/85/edbf85e5-931c-5da1-ae4c-78a23865efad/mza_9501009785385070744.jpg/600x600bb.jpg\",\n" +
        "                \"audioLink\": \"https://chtbl.com/track/G1127/traffic.omny.fm/d/clips/e0aa360c-d9fa-4c68-9743-aac8003c1d97/a1bb555e-a572-4211-aebe-aad400b964b1/84f4097e-39b8-4018-9215-af4b013f52d3/audio.mp3?utm_source=Podcast&in_playlist=f69a06e1-d9a9-4d33-aa63-aad400b964bf\",\n" +
        "                \"duration\": 10989,\n" +
        "                \"durationInSeconds\": 10989,\n" +
        "                \"views\": 0,\n" +
        "                \"podcastItunesId\": \"985515827\",\n" +
        "                \"podcastName\": \"فنجان مع عبدالرحمن أبومالح\",\n" +
        "                \"releaseDate\": \"2022-11-13T03:00:00Z\",\n" +
        "                \"createdAt\": \"2024-01-08T04:39:54.635Z\",\n" +
        "                \"updatedAt\": \"2024-01-08T04:39:54.635Z\",\n" +
        "                \"isDeleted\": false,\n" +
        "                \"chapters\": [],\n" +
        "                \"isEditorPick\": false,\n" +
        "                \"sentNotification\": false,\n" +
        "                \"position\": 0\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"OTU0MWE2YjYtMTJmMi00OWMzLWE3NWMtNTFiZTY5ZGUzYjdk\",\n" +
        "                \"itunesId\": \"OTU0MWE2YjYtMTJmMi00OWMzLWE3NWMtNTFiZTY5ZGUzYjdk\",\n" +
        "                \"type\": 0,\n" +
        "                \"name\": \"LEX - TCW Episode 117: The OLED Nintendo Switch.\",\n" +
        "                \"description\": \"<p>After selling a loft bed for the maximum allowable profit, Lex is disappointed that the weird van's model name doesn't sound like his name.</p>\",\n" +
        "                \"image\": \"https://ssl-static.libsyn.com/p/assets/7/5/2/e/752edbfe43978a39/lex_small.png\",\n" +
        "                \"imageBigger\": \"https://ssl-static.libsyn.com/p/assets/7/5/2/e/752edbfe43978a39/lex_small.png\",\n" +
        "                \"audioLink\": \"https://traffic.libsyn.com/secure/lextcw/LEX_116__The_OLED_Nintendo_Switch..m4a?dest-id=450202\",\n" +
        "                \"duration\": 494,\n" +
        "                \"durationInSeconds\": 494,\n" +
        "                \"views\": 0,\n" +
        "                \"podcastItunesId\": \"1186169374\",\n" +
        "                \"podcastName\": \"Lex: The Craigslist Whisperer\",\n" +
        "                \"releaseDate\": \"2023-03-15T04:45:00.000Z\",\n" +
        "                \"createdAt\": \"2023-08-07T12:39:13.310Z\",\n" +
        "                \"updatedAt\": \"2023-08-07T12:39:13.310Z\",\n" +
        "                \"isDeleted\": false,\n" +
        "                \"chapters\": [],\n" +
        "                \"isEditorPick\": false,\n" +
        "                \"sentNotification\": false,\n" +
        "                \"position\": 0\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"QnV6enNwcm91dC0xMjM4MzM4NQ==\",\n" +
        "                \"itunesId\": \"QnV6enNwcm91dC0xMjM4MzM4NQ==\",\n" +
        "                \"type\": 0,\n" +
        "                \"name\": \"( 1 ) اتصال الهم والهمة | د. مشاري الشثري و أ. ياسر الحزيمي | الحلقة الأولى\",\n" +
        "                \"description\": \"<p dir='rtl'>تحدثنا في هذه الحلقة عن الاتصال العلمي والمراد به، ومدى حاجة طلاب العلم لإدراك وجوهه، وتفاوتهم في التَّحصيل بحسب درجاتهم في حيازة تلك الوجوه وفقههم في إدارتها.<br/>وكان أولُ ما تحدثنا عنه من وجوه الاتصال (اتصال الهمِّ والهِمَّة) فبيَّنَّا أهميته وموقعه من وجوه الاتصال، وجرى في ضمن ذلك الحديث عن حبِّ العلم، ووسَّعنا الكلام عن السؤال المحوري في هذا الوجه، وهو: كيف يجمع طالبُ العلم همَّه؟ فتحدثنا عن التركيز العلمي ومجالاته.<br/><br/><a href='https://www.youtube.com/hashtag/%D8%A8%D9%88%D8%AF%D9%83%D8%A7%D8%B3%D8%AA_%D8%AE%D8%B7%D9%88%D8%A9'>#بودكاست_خطوة</a><br/><a href='https://www.youtube.com/hashtag/%D9%85%D8%B4%D8%A7%D8%B1%D9%8A_%D8%A7%D9%84%D8%B4%D8%AB%D8%B1%D9%8A'>#مشاري_الشثري</a><br/><a href='https://www.youtube.com/hashtag/%D9%8A%D8%A7%D8%B3%D8%B1_%D8%A7%D9%84%D8%AD%D8%B2%D9%8A%D9%85%D9%8A'>#ياسر_الحزيمي</a><br/><br/> المقدمة.<br/> ما المقصود بالاتصال العلمي؟ ولماذا الحديث عنه؟<br/> مُكوِّن (الالتزام العلمي) هو الفارق بين طالب العلم وغيره.<br/> مسألة قلَّ مَن يتنبَّه لها: أثر الشُّروع في طلب العلم.<br/> مجتمعات معرفيَّة رخوة!<br/> من المخاطب بالحديث عن الاتصال العلمي؟<br/> معارف المتجمهرين.<br/> وجوه الاتصال العلمي بين التَّذكير والاستحياء والتَّقويم.<br/> طالب العلم بين الأصول الضابطة والخطط العلميَّة المفصلة.<br/> بين الحديث (عن) العلم والحديث (في) العلم.<br/> الوجه الأول من وجوه الاتصال العلمي: اتصال الهمِّ والهِمَّة.<br/> (مَن عَلَت همَّتُه طالتْ همومُه).<br/> من فقه طالب العلم في التَّعامُل مع همومه العلميَّة.<br/> بين (الهَمِّ) و(الهِمَّة).<br/> مهادُ الهمِّ والهِمَّة: حبُّ العلم.<br/> العطاء العلمي وموقعه من تنمية حبِّ العلم والهمِّ والهِمَّة فيه.<br/> هل مِن الممكن أن تُثوِّر مرارةُ الجهل الهمَّةَ للعلم؟<br/> كيف يجمع طالبُ العلم همَّه؟<br/> (1) التركيز على العلم دون غيره من علائق الدُّنيا.<br/> (2) التركيز على مُهمِّ العلم دونَ غيره.<br/> (3) التركيز على الأفكار والأصول أكثر من المعلومات.<br/> مسالك تحصيل الأفكار والأصول الكلية(١.الألفاظ)<br/> مسالك تحصيل الأفكار والأصول الكلية(٢.السياقات)<br/> <br/>------------------<br/><br/>نسعدُ بمتابعتكم عَبر المنصات:<br/><br/>تويتر:<br/><a href='https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbkk4VTJCZDhtS1ZsVXVIYjFLN0FQclFRVFRCZ3xBQ3Jtc0tuc1FxSVBQZENyTnY1cHkycDhjelZnUFd4OC1WMmZJNi15azUyZ2lhbk5sbGYyUC10bmk3MkFLN3BEZm03amNPOXVySElQaHp2NnhYTTZ1ZGFzbGc1WGVTRk1nVEdISUYwWk14cGh4YlVQQnJMeGkxbw&q=https%3A%2F%2Ftwitter.com%2Fkhotwaah&v=6u9cBijP4vU'>https://twitter.com/khotwaah</a> <br/><br/>اليوتيوب <br/><a href='https://youtube.com/@khotwah'>   / @khotwah  </a><br/><br/><br/><br/>فيسبوك:<br/><a href='https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbHR4X3RKQTlXd1M1c1hvTG9uQ1VKdVZyRDZDQXxBQ3Jtc0ttWXpFZjJWQlgtUE5XY192d2M0Z3h4V3NpZzlNTGRZam9iYnNMVDNFM1Y0dEl4Zzg4ZFFoenRPYnFqRFE4YVZsbi1LZDYwal9SR0l2SzQtTV9NRlRBT0t6SDRLMnBLcUVZeExQRFh6VDVSSkJXOFN4WQ&q=https%3A%2F%2Ffacebook.com%2Fkhotwaah&v=6u9cBijP4vU'>https://facebook.com/khotwaah</a> <br/><br/>انستاجرام:<br/><a href='https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqazRudGRDaVVJSEZQMjkxLWhPNXpJVHlYS1h0UXxBQ3Jtc0tudGFxMk40NlNXdktpaF9PRmlMUTBEZmMxTmNxVUJoU1NsMnNlOUNyc0p3UllsV3RqeWtEQ2hjckx2TFc2OXprNkNmeUJ0NUJseUNJakc0YXRxaG5sekhZQzV3QU1MU092a2xzNUtzZmM5RFVpVmk1UQ&q=https%3A%2F%2Finstagram.com%2Fkhotwah_khotwah&v=6u9cBijP4vU'>https://instagram.com/khotwah_khotwah</a> <br/><br/>تلجرام:<br/><a href='https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbFVrTjRqUWpSa05TSXBMdEhUU2lLakJOWGU0d3xBQ3Jtc0tudWZtX3p5WW5keE5oNVVaTU15ZjY4S2l4aThXUGwxR3FBc0dhR3BfT3g3Vmk4NDB0WXctN3hPSVYtU1JpOVBiZkV0ZUp3UkdWUGtWVlJDN3pnRHhpa2lFaHNYNFNZS2FGWU5yYnN6V0N0bFFxVUJYOA&q=https%3A%2F%2Ft.me%2Fkhotwaah&v=6u9cBijP4vU'>https://t.me/khotwaah</a> <br/><br/>لينكدان:<br/><a href='https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbTFpUUFUbDBITlZBLUlQM0xmTTN3OEhNQjBCZ3xBQ3Jtc0tsbGFxZFY0U2xYYVB2NU1j</truncato-artificial-root>'></p>\",\n" +
        "                \"image\": \"https://is1-ssl.mzstatic.com/image/thumb/Podcasts122/v4/6d/29/88/6d298897-76d6-738c-451c-0e9cc5301a3d/mza_4849618384388417731.jpg/600x600bb.jpg\",\n" +
        "                \"imageBigger\": \"https://is1-ssl.mzstatic.com/image/thumb/Podcasts122/v4/6d/29/88/6d298897-76d6-738c-451c-0e9cc5301a3d/mza_4849618384388417731.jpg/600x600bb.jpg\",\n" +
        "                \"audioLink\": \"https://www.buzzsprout.com/2099869/12383385-1.mp3\",\n" +
        "                \"duration\": 6150,\n" +
        "                \"durationInSeconds\": 6150,\n" +
        "                \"views\": 0,\n" +
        "                \"podcastItunesId\": \"1660090729\",\n" +
        "                \"podcastName\": \"بودكاست خطوة\",\n" +
        "                \"releaseDate\": \"2023-03-06T12:00:00.000Z\",\n" +
        "                \"createdAt\": \"2023-04-02T21:05:15.888Z\",\n" +
        "                \"updatedAt\": \"2023-04-02T21:05:15.888Z\",\n" +
        "                \"isDeleted\": false,\n" +
        "                \"chapters\": [],\n" +
        "                \"isEditorPick\": false,\n" +
        "                \"sentNotification\": false,\n" +
        "                \"position\": 0\n" +
        "            }\n" +
        "        ]\n" +
        "    }\n" +
        "}"