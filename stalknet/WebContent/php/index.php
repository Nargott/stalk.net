<?php

	/*
		conv table generation SQL
		CREATE TABLE conv (SELECT node_revisions.nid as nr_nid, node_revisions.vid as nr_vid, node_revisions.uid as nr_uid, node_revisions.title, users.*, content_type_profile.*
							FROM node_revisions, users, content_type_profile
							WHERE node_revisions.uid = users.uid
							AND node_revisions.format =0
							AND node_revisions.nid = content_type_profile.nid
							ORDER BY node_revisions.uid, node_revisions.nid ASC)
	*/
	
	/*show data
		//$heads=explode(",	", "nid,	vid,	uid,	title,	body,	teaser,	log,	timestamp,	format,	name,	pass,	mail,	mode,	sort,	threshold,	theme,	signature,	signature_format,	created,	access,	login,	status,	timezone,	language,	picture,	init,	data,	timezone_name,	timezone_id,	field_fio_value,	field_birth_value,	field_city_value,	field_repneitr_value,	field_phone_value,	field_repdolg_value,	field_repsvob_value,	field_repband_value,	field_repuch_value,	field_repvoen_value,	field_numpas_value,	field_zamuch_value,	field_legend_s_value,	field_quest_nid,	field_money_value,	field_expirience_value,	field_suit_value,	field_legend_mast_value");
		/*echo("<table border='1px'>\n");
		echo("\x20<thead>");echo("<th>#</th>");foreach ($heads as $h) {echo("<th>".$h['Field']."</th>");}echo("</thead>\n");
		echo("\x20<tbody>\n");
		$i=0;
		foreach ($res as $r) {
			echo("\x20\x20<tr>\n");
			echo("\x20\x20\x20<td><b>".($i++)."</b></td>");
			foreach ($r as $k=>$d) {
				echo("\x20\x20\x20<td>".((strlen($d) > 55) ? substr($d,0,50).'<font color=\"#0000ff\" size=5>...</font>' : $d)."</td>");
			}
			echo("\n\x20\x20</tr>\n");
		}
		echo("\x20</tbody>\n");
		echo("</table>\n");
	*/
	require_once("safemysql.class.php");
	
	function randomPassword() {
		$alphabet = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ0123456789";
		for ($i = 0; $i < 8; $i++) {
			$n = rand(0, count($alphabet)-1);
			$pass[$i] = $alphabet[$n];
		}
		return $pass;
	}
	
	$db = new SafeMySQL(array('user' => 'root', 'pass' => 'root', 'db' => 'stalknet', 'charset' => 'cp1251')); 
	
	$heads = $db->getAll("SHOW COLUMNS FROM conv;");
	$res = $db->getAll("SELECT * FROM `conv` GROUP BY uid HAVING COUNT(*)=1;");
	
	
	$sql="INSERT INTO `users` (`id`, `login`, `email`, `pass`, `fio`, `picture`, `rights`, `city`, `phone`, `description`,`birthdate`, `created`, `lastlogin`) VALUES \n  ";
	foreach ($res as $d) {
		if (strlen($d['pass'])>0) {
			$desc='NULL';
			$res2 = $db->getRow("SELECT * FROM `city` WHERE name='".$d['field_city_value']."';");
			if (strlen($res2["id"])>0) {
				//echo($res2["id"]." - ".$res2["name"]."<br>\n");} 
				$city=$res2["id"];
			} else {
				//echo("<font color='red'>NULL - ".$d['field_city_value'].": (".$d['uid'].",".$d['nid'].")".$d['title']."</font><br>\n");
				$city='NULL';
				$desc="'".$d['field_city_value']."'";
			}
			
			$bdate=date( 'Y-m-d H:i:s', strtotime($d['field_birth_value']) );
			$cdate=date( 'Y-m-d H:i:s', $d['created'] );
			$ldate=date( 'Y-m-d H:i:s', $d['login'] );
			$sql.="(NULL, '".$d['name']."', '".$d['mail']."', '".$d['pass']."', '".$d['field_fio_value']."', '".$d['picture']."', 0, $city, '".$d['field_phone_value']."', $desc,'$bdate', '$cdate', '$ldate'), \n";
		}
		
	}
	$sql=substr_replace($sql,';',-3);
	echo($sql);
	$res = $db->getOne($sql);
	var_dump($res);
?>