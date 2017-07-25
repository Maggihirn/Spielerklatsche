����   4y  de/maggi/spielerklatsche/main  !org/bukkit/plugin/java/JavaPlugin  org/bukkit/event/Listener file Ljava/io/File; cfg 1Lorg/bukkit/configuration/file/YamlConfiguration; name Ljava/lang/String; <clinit> ()V Code  java/io/File  $plugins//Spielerklatsche//config.yml
     <init> (Ljava/lang/String;)V	    
    /org/bukkit/configuration/file/YamlConfiguration   loadConfiguration A(Ljava/io/File;)Lorg/bukkit/configuration/file/YamlConfiguration;	  ! 	 
 LineNumberTable LocalVariableTable
  %   ' §3§lSpielerklatsche	  )   this Lde/maggi/spielerklatsche/main; onEnable
 . 0 / org/bukkit/Bukkit 1 2 getPluginManager #()Lorg/bukkit/plugin/PluginManager; 4 6 5 org/bukkit/plugin/PluginManager 7 8 registerEvents 8(Lorg/bukkit/event/Listener;Lorg/bukkit/plugin/Plugin;)V
  : ; < 	getConfig 3()Lorg/bukkit/configuration/file/FileConfiguration;
 > @ ? /org/bukkit/configuration/file/FileConfiguration A B options :()Lorg/bukkit/configuration/file/FileConfigurationOptions;
 D F E 6org/bukkit/configuration/file/FileConfigurationOptions G H copyDefaults ;(Z)Lorg/bukkit/configuration/file/FileConfigurationOptions;
  J K  
saveConfig 	onCommand f(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z O org/bukkit/entity/Player
  Q R S 	createInv "()Lorg/bukkit/inventory/Inventory;
 U W V org/bukkit/command/Command X Y getName ()Ljava/lang/String; [ Spielerklatsche
 ] _ ^ java/lang/String ` a equalsIgnoreCase (Ljava/lang/String;)Z c spielerklatsche.use N e f a hasPermission h 5§6§lDu hast die Spielerklatsche in deinem Inventar! N j k  sendMessage
  m n o giveKlatsche (Lorg/bukkit/entity/Player;)V q settings N s t u openInventory F(Lorg/bukkit/inventory/Inventory;)Lorg/bukkit/inventory/InventoryView; w §4Du hast keine Rechte dazu! sender "Lorg/bukkit/command/CommandSender; cmd Lorg/bukkit/command/Command; label args [Ljava/lang/String; p Lorg/bukkit/entity/Player; inv  Lorg/bukkit/inventory/Inventory; StackMapTable � org/bukkit/inventory/Inventory � org/bukkit/inventory/ItemStack	 � � � org/bukkit/Material � � STAINED_GLASS_PANE Lorg/bukkit/Material;
 � �  � (Lorg/bukkit/Material;)V
 � � � � getItemMeta &()Lorg/bukkit/inventory/meta/ItemMeta; � Platzhalter � � � "org/bukkit/inventory/meta/ItemMeta �  setDisplayName
 � � � � setItemMeta '(Lorg/bukkit/inventory/meta/ItemMeta;)Z	 � � � � 
WATER_LILY
 � �  � (Lorg/bukkit/Material;I)V � §6§lStufe 1 � §6§lStufe 2 � §6§lStufe 3 � §6§lStufe 4 � Wähle eine Stärke!
 . � � � createInventory [(Lorg/bukkit/inventory/InventoryHolder;ILjava/lang/String;)Lorg/bukkit/inventory/Inventory; � � � � setItem $(ILorg/bukkit/inventory/ItemStack;)V G  Lorg/bukkit/inventory/ItemStack; ig $Lorg/bukkit/inventory/meta/ItemMeta; i im i1 im1 i2 im2 i3 im3 � §6§lSpielerklatsche � Made by Maggihirn
 � � � java/util/Arrays � � asList %([Ljava/lang/Object;)Ljava/util/List; � � � � setLore (Ljava/util/List;)V N � � � getInventory (()Lorg/bukkit/inventory/PlayerInventory; � � � $org/bukkit/inventory/PlayerInventory � � addItem 6([Lorg/bukkit/inventory/ItemStack;)Ljava/util/HashMap; material ammount I item itemMeta onClick 3(Lorg/bukkit/event/inventory/InventoryClickEvent;)V RuntimeVisibleAnnotations Lorg/bukkit/event/EventHandler;
 � � � .org/bukkit/event/inventory/InventoryClickEvent � � getWhoClicked !()Lorg/bukkit/entity/HumanEntity; � Spielerklatsche.use � e � org/bukkit/entity/HumanEntity
 � � � S � W
 � � � � getCurrentItem "()Lorg/bukkit/inventory/ItemStack; � � � Y getDisplayName � java/lang/StringBuilder � W
 ] � �  valueOf &(Ljava/lang/Object;)Ljava/lang/String;
 �  	.strength
 � append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 �	
 Y toString
 java/lang/Integer � (I)Ljava/lang/Integer;
 > set '(Ljava/lang/String;Ljava/lang/Object;)V 1§6§lDie Stärke wurde auf §71§6§l geändert! � j
 � setCancelled (Z)V 1§6§lDie Stärke wurde auf §72§6§l geändert! 1§6§lDie Stärke wurde auf §73§6§l geändert!  1§6§lDie Stärke wurde auf §74§6§l geändert! e 0Lorg/bukkit/event/inventory/InventoryClickEvent; Lorg/bukkit/entity/HumanEntity; 
onInteract 0(Lorg/bukkit/event/player/PlayerInteractEvent;)V -Lorg/bukkit/event/player/PlayerInteractEvent; 	onKlatsch 6(Lorg/bukkit/event/player/PlayerInteractEntityEvent;)V
*,+ 1org/bukkit/event/player/PlayerInteractEntityEvent-. getRightClicked ()Lorg/bukkit/entity/Entity;
*012 	getPlayer ()Lorg/bukkit/entity/Player;
 45  reloadConfig N W
 >89: getInt (Ljava/lang/String;)I �<= � getItemInMainHand
 �?@A getType ()Lorg/bukkit/Material;
 ]CDE equals (Ljava/lang/Object;)Z NGHI getLocation ()Lorg/bukkit/Location;
KML org/bukkit/LocationNO getDirection ()Lorg/bukkit/util/Vector;
QSR org/bukkit/util/VectorTU multiply (I)Lorg/bukkit/util/Vector; NWXY setVelocity (Lorg/bukkit/util/Vector;)V[ §6§lDu hast§r ]  §6§lweggeklatscht! N_`a setFallDistance (F)V Ncde getWorld ()Lorg/bukkit/World;	gih org/bukkit/Soundjk ENTITY_PLAYER_ATTACK_KNOCKBACK Lorg/bukkit/Sound;@�  Ap  oqp org/bukkit/Worldrs 	playSound ,(Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V 3Lorg/bukkit/event/player/PlayerInteractEntityEvent; d 
multiplier 
SourceFile 	main.java !      	     	 	 
         	        :      � Y� � � � �  �    "   
       #             =     *� $*&� (�    "          
  #        * +    ,      Q     � -**� 3 *� 9� =� CW*� I�    "       ! 
 "  #  $ #        * +    L M         d+� N:*� P:,� TZ� \� Mb� d � 8�� g� i *� l�� %2p� \� � r W� v� i �    "   6    (  *  ,  - $ . * / 3 0 9 3 @ 4 L 5 V 9 Y : b ? #   H    d * +     d x y    d z {    d |     d } ~   ^  �   X � �  �    � 9 N �  R S    #    � �Y� �� �L+� �M,�� � +,� �W� �Y� �� �N-� �:�� � -� �W� �Y� �� �:� �:�� � � �W� �Y� �� �:� �:�� � � �W� �Y� �� �:		� �:

�� � 	
� �W	�� �:+� � -� � +� � � � +� � � � +� � 	� � +� � �    "   ~    D  E  F  G  I * J 0 K 9 L @ N M O T P ] Q e S r T y U � V � X � Y � Z � [ � ^ � _ � ` � a � b � c � d � e � f g h #   z    * +    � �   � �  * � � �  0 � � �  M � � �  T � � �  r � � �  y � � �  � | � � 	 � u � � 
 � Z � �   n o     �     V� �M>�:� �Y,� �:� �:� � � ]Y�S� ȹ � � �W+� � � �YS� � W�    "   * 
   m  n  o 
 p  q  r % s 8 t @ u U w #   H    V * +     V  �   R � �   P � �  
 L     A � �   : � �   � �  �     �     M    �+� �M,� � �u+� � � �� \�d+� � �� � �� \� A*� 9W*� 9� �Y,� � � ������*� I,� +��+� � �� � �� \� A*� 9W*� 9� �Y,� � � ������*� I,� +�� �+� � �� � �� \� A*� 9W*� 9� �Y,� � � ������*� I,� +�� n+� � �� � �� \� A*� 9W*� 9� �Y,� � � ������*� I,� +�� +� � �� � �� \� +��    "   z    {  |  } ! ~ 5  : � ^ � b � k � p � � � � � � � � � � � � � � � � � � � � �+ �0 �T �X �a �f �} �� � #       � * +    �!"  ~ #  �    � s �� Q� Q� Q $%  �     �      5      �    "       � #        * +     !&  '(  �     �     Q     �+�)� NM+�/N*�3*� 9� �Y-�6 � �����76-� d � �-� � �; �>� �� u-� � �; � �� � ĶB� Z,-�F �J�P�V -� �YZ�,�6 �\��� i ,�^ ,�b ,�F �flm�n �    "   .    �  �  �  � 3 � > � m � � � � � � � � � #   4    � * +     �!t   �  �   �u �  3 �v �  �    � � N N w   x