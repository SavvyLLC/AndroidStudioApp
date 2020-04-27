// DO NOT EDIT! This is an autogenerated file. All changes will be
// overwritten!

//	Copyright (c) 2016 Vidyo, Inc. All rights reserved.


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.Runtime.InteropServices;

namespace VidyoClient
{
	public class EventScheduleFactory
	{
#if __IOS__
		const string importLib = "__Internal";
#else
		const string importLib = "libVidyoClient";
#endif
		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		public static extern IntPtr VidyoEventScheduleConstructDefaultNative();
		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		public static extern void VidyoEventScheduleDestructNative(IntPtr obj);
		public static EventSchedule Create()
		{
			IntPtr objPtr = VidyoEventScheduleConstructDefaultNative();
			return new EventSchedule(objPtr);
		}
		public static void Destroy(EventSchedule obj)
		{
			VidyoEventScheduleDestructNative(obj.GetObjectPtr());
		}
	}
	public class EventSchedule{
#if __IOS__
		const string importLib = "__Internal";
#else
		const string importLib = "libVidyoClient";
#endif
		private IntPtr objPtr; // opaque VidyoEventSchedule reference.
		public IntPtr GetObjectPtr(){
			IntPtr nByDay = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(byDay ?? string.Empty);
			IntPtr nByMonth = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(byMonth ?? string.Empty);
			IntPtr nByMonthDay = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(byMonthDay ?? string.Empty);
			IntPtr nBySetPos = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(bySetPos ?? string.Empty);
			IntPtr nByWeekNum = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(byWeekNum ?? string.Empty);
			IntPtr nByYearDay = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(byYearDay ?? string.Empty);
			IntPtr nCount = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(count ?? string.Empty);
			IntPtr nDuration = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(duration ?? string.Empty);
			IntPtr nEndTime = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(endTime ?? string.Empty);
			IntPtr nEventId = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(eventId ?? string.Empty);
			IntPtr nFrequency = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(frequency ?? string.Empty);
			IntPtr nInterval = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(interval ?? string.Empty);
			IntPtr nStartTime = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(startTime ?? string.Empty);
			IntPtr nUntil = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(until ?? string.Empty);
			IntPtr nWeekStartDay = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(weekStartDay ?? string.Empty);

			VidyoEventScheduleSetbyDayNative(objPtr, nByDay);
			VidyoEventScheduleSetbyMonthNative(objPtr, nByMonth);
			VidyoEventScheduleSetbyMonthDayNative(objPtr, nByMonthDay);
			VidyoEventScheduleSetbySetPosNative(objPtr, nBySetPos);
			VidyoEventScheduleSetbyWeekNumNative(objPtr, nByWeekNum);
			VidyoEventScheduleSetbyYearDayNative(objPtr, nByYearDay);
			VidyoEventScheduleSetcountNative(objPtr, nCount);
			VidyoEventScheduleSetdurationNative(objPtr, nDuration);
			VidyoEventScheduleSetendTimeNative(objPtr, nEndTime);
			VidyoEventScheduleSeteventIdNative(objPtr, nEventId);
			VidyoEventScheduleSetfrequencyNative(objPtr, nFrequency);
			VidyoEventScheduleSetintervalNative(objPtr, nInterval);
			VidyoEventScheduleSetstartTimeNative(objPtr, nStartTime);
			VidyoEventScheduleSetuntilNative(objPtr, nUntil);
			VidyoEventScheduleSetweekStartDayNative(objPtr, nWeekStartDay);

			Marshal.FreeHGlobal(nWeekStartDay);
			Marshal.FreeHGlobal(nUntil);
			Marshal.FreeHGlobal(nStartTime);
			Marshal.FreeHGlobal(nInterval);
			Marshal.FreeHGlobal(nFrequency);
			Marshal.FreeHGlobal(nEventId);
			Marshal.FreeHGlobal(nEndTime);
			Marshal.FreeHGlobal(nDuration);
			Marshal.FreeHGlobal(nCount);
			Marshal.FreeHGlobal(nByYearDay);
			Marshal.FreeHGlobal(nByWeekNum);
			Marshal.FreeHGlobal(nBySetPos);
			Marshal.FreeHGlobal(nByMonthDay);
			Marshal.FreeHGlobal(nByMonth);
			Marshal.FreeHGlobal(nByDay);
			return objPtr;
		}
		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetbyDayNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetbyDayNative(IntPtr obj, IntPtr byDay);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetbyMonthNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetbyMonthNative(IntPtr obj, IntPtr byMonth);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetbyMonthDayNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetbyMonthDayNative(IntPtr obj, IntPtr byMonthDay);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetbySetPosNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetbySetPosNative(IntPtr obj, IntPtr bySetPos);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetbyWeekNumNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetbyWeekNumNative(IntPtr obj, IntPtr byWeekNum);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetbyYearDayNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetbyYearDayNative(IntPtr obj, IntPtr byYearDay);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetcountNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetcountNative(IntPtr obj, IntPtr count);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetdurationNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetdurationNative(IntPtr obj, IntPtr duration);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetendTimeNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetendTimeNative(IntPtr obj, IntPtr endTime);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGeteventIdNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSeteventIdNative(IntPtr obj, IntPtr eventId);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetfrequencyNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetfrequencyNative(IntPtr obj, IntPtr frequency);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetintervalNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetintervalNative(IntPtr obj, IntPtr interval);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetstartTimeNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetstartTimeNative(IntPtr obj, IntPtr startTime);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetuntilNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetuntilNative(IntPtr obj, IntPtr until);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoEventScheduleGetweekStartDayNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoEventScheduleSetweekStartDayNative(IntPtr obj, IntPtr weekStartDay);

		public String byDay;
		public String byMonth;
		public String byMonthDay;
		public String bySetPos;
		public String byWeekNum;
		public String byYearDay;
		public String count;
		public String duration;
		public String endTime;
		public String eventId;
		public String frequency;
		public String interval;
		public String startTime;
		public String until;
		public String weekStartDay;
		public EventSchedule(IntPtr obj){
			objPtr = obj;

			byDay = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetbyDayNative(objPtr));
			byMonth = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetbyMonthNative(objPtr));
			byMonthDay = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetbyMonthDayNative(objPtr));
			bySetPos = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetbySetPosNative(objPtr));
			byWeekNum = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetbyWeekNumNative(objPtr));
			byYearDay = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetbyYearDayNative(objPtr));
			count = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetcountNative(objPtr));
			duration = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetdurationNative(objPtr));
			endTime = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetendTimeNative(objPtr));
			eventId = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGeteventIdNative(objPtr));
			frequency = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetfrequencyNative(objPtr));
			interval = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetintervalNative(objPtr));
			startTime = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetstartTimeNative(objPtr));
			until = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetuntilNative(objPtr));
			weekStartDay = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoEventScheduleGetweekStartDayNative(objPtr));
		}
	};
}
